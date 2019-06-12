package com.blue.sso.constants;

/**
 * @description SSO常量类
 * @author orcas
 * @since 2019/6/12
 **/
public interface SSOConstants {

    interface ResultCode{
        /**
         * 成功
         */
        String SUCCESS = "200";
        /**
         * 资源不存在
         */
        String NOT_FOUND = "404";
        /**
         * 失败
         */
        String FAILURE = "500";
    }

}
