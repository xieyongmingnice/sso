package com.blue.sso.dao;

import com.blue.sso.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description 用户持久层操作接口
 * @author orcas
 * @since 2019/6/9
 **/
@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    User findByUsernameAndPassword(String username, String password);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户实体
     */
    User findByUsername(String username);
}
