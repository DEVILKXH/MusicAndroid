package com.devil.music.utils;

import java.util.regex.Pattern;

/**
 * Created by Devil on 2017/3/7.
 */

public class StringUtils {
    /**
     * 是否为空
     * @param str
     * @return
     */
    public static boolean isNullOrBlank(String str){
        if("".equals(str) || str == null || str.length() == 0){
            return true;
        }
        return false;
    }

    /**
     *判断不为空
     * @param str
     * @return
     */
    public static boolean isNotNullOrBlank(String str){
        if(!"".equals(str) &&  str != null || str.length() > 0){
            return true;
        }
        return false;
    }

    /**
     * 校验密码 len > 6 && \w
     * @param password
     * @return
     */
    public static boolean checkPassword(String password){
        if(password.length() < 6){
            return false;
        }
        Pattern pattern = Pattern.compile("[\\d]");
        Pattern pattern1 = Pattern.compile("[a-zA-Z]");
        boolean b = false;
        if(pattern.matcher(password).find() && pattern1.matcher(password).find()){
            b = true;
        }
        return b;
    }

    /**
     * 校验手机
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone){
        Pattern pattern = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");
        return pattern.matcher(phone).find()?true: false;
    }

    /**
     * 校验邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        Pattern pattern = Pattern.compile("\\w+@([a-zA-Z0-9]\\.)+[a-zA-Z]{2,4}");
        return pattern.matcher(email).find()?true:false;
    }
}
