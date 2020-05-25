package com.elderlycaresystem.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 随机生成用户编号
 * CharLinHeng
 * 2020年3月28日23:44:17
 */
public class RandomCode {
    public static String radmonkey(){
        //6

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuffer sbf=new StringBuffer();

        sbf.append(sdf.format(new Date()));
        for (int i = 0; i <18; i++) {
            int num=(int)(Math.random()*10);
            sbf.append(num);
        }
        return sbf.toString();
    }

    /**
     * 短信验证码Test
     * @return
     */
    public static String randomPhoneCode() {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int num = (int) (Math.random() * 10);
            sbf.append(num);

        }
        return sbf.toString();
    }
}
