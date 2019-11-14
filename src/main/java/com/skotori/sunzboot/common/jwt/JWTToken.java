package com.skotori.sunzboot.common.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * jwtToken实体类
 * @author skotori
 * @date 2019-11-08 11:47
 */
public class JWTToken implements AuthenticationToken {

    private static final long serialVersionUID = 1282057025599826155L;

    private String token;

    private String expiresAt;

    public JWTToken(String token) {
        this.token = token;
    }

    public JWTToken(String token, String expiresAt) {
        this.token = token;
        this.expiresAt = expiresAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
