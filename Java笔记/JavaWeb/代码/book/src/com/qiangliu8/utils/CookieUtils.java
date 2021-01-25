package com.qiangliu8.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie findCookie(String name,Cookie Cookies[]){
        Cookie myCookie = null;
        for (Cookie cookie : Cookies) {
            if (cookie.getName().equals(name)){
                myCookie = cookie;
                return myCookie;
            }
        }
        return null;
    }
}
