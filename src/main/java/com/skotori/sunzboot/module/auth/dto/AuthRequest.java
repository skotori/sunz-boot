package com.skotori.sunzboot.module.auth.dto;

/**
 * 认证请求数据封装
 * @author skotori
 * @date 2019-11-08 16:00
 */
public class AuthRequest {

    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
