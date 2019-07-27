package com.ywh.bean;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date date = new Date()； //获取当前系统时间
 * format: 按指定的目标格式把Date对象转换为String
 * parse: 按指定的源格式把String转换为Date对象
 * Date date = new Date();
 *
 *         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
 *
 *         String dateFormat = sdf.format(date);
 *
 *         Date dateFormatParse = sdf.parse(dateFormat);
 * Author:ywh
 * Date:2019/07/26
 */
public class DateEdit extends PropertyEditorSupport{

    private String format="yyyy-MM-dd";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("text="+text);
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        try {
            Date date =sdf.parse(text);
            this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
