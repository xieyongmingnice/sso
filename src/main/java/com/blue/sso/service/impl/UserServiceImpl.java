package com.blue.sso.service.impl;

import com.blue.sso.dao.UserDao;
import com.blue.sso.entity.User;
import com.blue.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @description 用户Service实现类
 * @author orcas
 * @since 2019/6/9
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User userSignUp(User user) {
        return userDao.save(user);
    }

    @Override
    public User userLogin(String username, String password) {
        return userDao.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
