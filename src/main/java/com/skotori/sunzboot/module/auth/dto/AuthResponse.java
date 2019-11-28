package com.skotori.sunzboot.module.auth.dto;

import com.skotori.sunzboot.common.shiro.ShiroUser;

/**
 * 认证响应数据封装
 * @author skotori
 * @date 2019-11-08 16:08
 */
public class AuthResponse {

    private ShiroUser user;
    private String token;

    public AuthResponse(ShiroUser user, String token) {
        this.user = user;
        this.token = token;
    }

    public ShiroUser getUser() {
        return user;
    }

    public void setUser(ShiroUser user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "user=" + user +
                ", token='" + token + '\'' +
                '}';
    }
}
