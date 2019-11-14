package com.skotori.sunzboot.module.auth.dto;

import com.skotori.sunzboot.common.jwt.JWTToken;
import com.skotori.sunzboot.module.sys.model.SysUser;

/**
 * 认证响应数据封装
 * @author skotori
 * @date 2019-11-08 16:08
 */
public class AuthResponse {

    private SysUser user;
    private JWTToken token;

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public JWTToken getToken() {
        return token;
    }

    public void setToken(JWTToken token) {
        this.token = token;
    }

}
