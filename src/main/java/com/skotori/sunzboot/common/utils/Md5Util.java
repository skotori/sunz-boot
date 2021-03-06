package com.skotori.sunzboot.common.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.Random;

/**
 * md5工具类
 * @author skotori
 * @date 2020-08-04 11:48
 */
public class Md5Util {

    // 加密方式
    private static final String HASH_ALGORITHM_NAME = "MD5";

    // 循环加密次数
    private static final Integer HASH_ITERATIONS = 1024;

    // 盐值长度
    private static final Integer SALT_LENGTH = 5;

    // 盐值随机库
    private static final String BASE_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * md5加密
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
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < SALT_LENGTH; i++) {
            int number = random.nextInt(BASE_STRING.length());
            sb.append(BASE_STRING.charAt(number));
        }
        return String.valueOf(sb);
    }

}
