package com.blue.sso.vo;

/**
 * @description 返回给前端页面的VO类
 * @author orcas
 * @since 2019/6/12
 **/
public class ResultVO<T>{

    /**
     * 状态码
     * @see
     */
    private String code;

    /**
     *
     */
    private String msg;

    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
