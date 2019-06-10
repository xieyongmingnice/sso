package com.blue.sso.controller;

import com.blue.sso.entity.User;
import com.blue.sso.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 登录控制器
 * @author orcas
 * @since 2019/6/8
 **/
@RestController
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    public String signUp(User user){
        userService.userSignUp(user);
        return "注册成功";
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
        logger.info("请求登录~~~~,{}",request);
        userService.userLogin(username,password);
        return "登录成功";
    }
}
