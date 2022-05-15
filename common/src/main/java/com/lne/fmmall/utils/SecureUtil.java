package com.lne.fmmall.utils;


import cn.hutool.crypto.digest.DigestUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * FileName: SecureUtil
 * Author:   fengsulin
 * Date:     2022/4/23 22:26
 * Description: 安全工具类
 */
public class SecureUtil {
    /**密码和盐的长度*/
    private static final int PASSWORD_AND_SALT_LENGTH = 64;

    /**
     * 生成带有随机盐的md5密码
     * @param: [password, salt]
     * @return: java.lang.String
     */
    public static String generateMd5Salt(String password, String salt){
        password = DigestUtil.md5Hex(password+salt, Charset.forName("UTF-8"));
//        int pwdLen = password.length();
//        int saltLen = salt.length();
//        if(pwdLen < 32){
//            for(int i = 0;i<32 - pwdLen;i++){}
//            password += 0 ;
//        }
//        if(saltLen < 32){
//            for(int i = 0;i<32 - saltLen;i++){
//                salt += 0;
//            }
//        }
//        char[] md5 = new char[PASSWORD_AND_SALT_LENGTH];
//        for(int i = 0;i<PASSWORD_AND_SALT_LENGTH;i++){
//            md5[i] = password.charAt(i / 2);
//            md5[++i] = salt.charAt(i / 2);
//        }
//        return new String(md5);
        return password;
    }

    /**
     * 校验密码
     * @param: [password, md5]
     * @return: boolean
     */
    public static boolean verifyMd5Salt(String password,long uuid,String md5){
//        char[] pwd = new char[32];
//        char[] salt = new char[32];
//        for(int i = 0;i < PASSWORD_AND_SALT_LENGTH;i++){
//            pwd[i / 2] = md5.charAt(i);
//            salt[i / 2] = md5.charAt(++i);
//        }
//        return DigestUtil.md5Hex(password+new String(salt)).equals(new String(pwd));
        return DigestUtil.md5Hex(password+uuid,Charset.forName("UTF-8")).equals(md5);
    }
}
