package com.cn.topsroboteer.scheduling.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName IdUtils
 * @Description Id生成器
 * @Author 郭凯
 * @Date 2020/4/26 14:12
 * @Version 1.0
 **/
public class IdUtils {

    public static Long getSeqId() {
        String sformat = "MMddhhmmssSSS";
        int num = 2;
        String idStr = getDate(sformat) + getRandomNum(num);
        Long id = Long.valueOf(idStr);
        return id;
    }
    /**
     * 功能描述: 获取数据区ID 15位
     * @Param:指定的格式
     * @Return:格式化之后的日期字符串
     * @Author: 郭凯
     * @Date: 2020/4/26 14:21
     */
    public static String getDate(String sformat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     *
     * @param num 随机数位数
     * @return 0~9之间的两位随机数的字符串
     */
    public static String getRandomNum(int num) {
        String numStr = "";
        for (int i = 0; i < num; i++) {
            numStr += (int) (10 * (Math.random()));
        }
        return numStr;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
