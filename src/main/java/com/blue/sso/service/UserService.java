package com.blue.sso.service;

import com.blue.sso.entity.User;

/**
 * @description 用户service接口
 * @author orcas
 * @since 2019/6/9
 **/
public interface UserService {

    /**
     * 用户注册
     * @param user 用户
     * @return
     */
    User userSignUp(User user);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User userLogin(String username, String password);


}
