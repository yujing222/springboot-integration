package com.elastic.search.util;

import org.joda.time.DateTime;
import java.util.Date;

/**
 * 基于 JODA 组件的时间工具类
 */
public class DateUtil {

    private DateUtil (){}

    public static final String DATE_FORMAT_01 = "yyyy-MM-dd HH:mm:ss" ;
    public static final String DATE_FORMAT_02 = "yyyyMMdd" ;
    /**
     * 指定格式获取时间
     */
    public static String formatDate (Date date,String dateFormat){
        DateTime dateTime = new DateTime(date) ;
        return dateTime.toString(dateFormat) ;
    }
}
