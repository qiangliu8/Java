package com.qiangliu8.utils;

import org.apache.commons.beanutils.BeanUtils;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            /*
            把所有请求的注入到User对象中
            * */
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int ParseInt(String str,int defaultValue){
        try {
            return Integer.parseInt(str);
        } catch (Exception e){
            //e.printStackTrace();
        }
        return defaultValue;
    }
}
