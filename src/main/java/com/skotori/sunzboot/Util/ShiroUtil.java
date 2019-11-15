package com.skotori.sunzboot.Util;

import com.skotori.sunzboot.common.shiro.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import java.util.Random;

/**
 * shiro工具类
 * @author skotori
 * @date 2019-11-15 10:33
 */
public class ShiroUtil {

    // 加密方式
    private static final String HASH_ALGORITHM_NAME = "MD5";

    // 循环加密次数
    private static final Integer HASH_ITERATIONS = 1024;

    // 盐值长度
    private static final Integer SALT_LENGTH = 5;

    /**
     * shiro密码加密工具
     * @param password
     * @param credentialsSalt
     * @return
     */
    public static String md5(String password, String credentialsSalt) {
        ByteSource salt = new Md5Hash(credentialsSalt);
        return String.valueOf(new SimpleHash(HASH_ALGORITHM_NAME, password, salt, HASH_ITERATIONS));
    }

    /**
     * 获取随机盐值
     * @return
     */
    public static String getRandomSalt() {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < SALT_LENGTH; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return String.valueOf(sb);
    }

    /**
     * 获取当前Subject
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取封装的shiroUser
     * @return
     */
    public static ShiroUser getUser() {
        return (ShiroUser) getSubject().getPrincipals().getPrimaryPrincipal();
    }
}
