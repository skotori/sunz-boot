package com.skotori.sunzboot.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * jwt工具类
 * @author skotori
 * @date 2019-11-08 11:50
 */
public class JWTUtil {

    private static Logger log = LoggerFactory.getLogger(JWTUtil.class);

    // token有效时间，单位秒
    private static final long EXPIRE_TIME = 5 * 60 * 1000; // 5分钟

    /**
     * 校验token
     * @param token
     * @param account
     * @param password
     * @return
     */
    public static boolean verify(String token, String account, String password) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("account", account)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 从token中获取account
     * @param token
     * @return
     */
    public static String getAccount(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("account").asString();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 生成token
     * @param account
     * @param password
     * @return
     */
    public static String sign(String account, String password) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(password);
            return JWT.create()
                    .withClaim("account", account)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

}
