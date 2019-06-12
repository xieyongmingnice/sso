package com.blue.sso.controller;

import com.blue.sso.entity.User;
import com.blue.sso.service.UserService;
import com.blue.sso.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 用户控制器
 * @author orcas
 * @since 2019/6/8
 **/
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    public ResultVO<String> signUp(User user){
        ResultVO<String> resultVO = new ResultVO<>();
        userService.findUserByUsername(user.getUsername());
        userService.userSignUp(user);
        return resultVO;
    }
    /**
     * 用户登录
     * @param request http请求
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, String username, String password){
        String success = "登录失败";
        logger.info("请求登录~~~~,{}",request);
        User user = userService.userLogin(username,password);
        if (null != user){
            threadLocal.set(user);
            success = "登录失败";
            logger.info("登录成功");
        }
        return success;
    }
}
