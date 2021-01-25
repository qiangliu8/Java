package com.qiangliu8.json.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18ntest {
    @Test
    public void testLocale(){
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        ResourceBundle bundle = ResourceBundle.getBundle("i18n",Locale.CHINA);
        System.out.println(bundle.getString("username"));

    }
}
