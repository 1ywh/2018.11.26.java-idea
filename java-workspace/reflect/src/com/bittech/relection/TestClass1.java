package com.bittech.relection;

import java.util.Date;

/**
 * 对象的实例化
 * new 构造 序列化 利用反射实例化对象
 * Author:ywh
 * Date:2019/03/09
 */
public class TestClass1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1.getClass()方法
        Date date = new Date();
        Class cls = date.getClass();
        try {
            Date date1 = (Date) cls.newInstance();
            System.out.println("1 " + date1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //2.全限定类名.class
        Class<java.util.Date> cls2 = java.util.Date.class;
        try {
            Date date3 = cls2.newInstance();
            System.out.println("2 "+date3);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Date date3 = cls2.newInstance();
        System.out.println("2 "+date3);
        //3.Class.forName方法
        Class cls1 = Class.forName("java.util.Date");
        Object date2 = cls1.newInstance();
        System.out.println("3 " + date2);

    }


}
