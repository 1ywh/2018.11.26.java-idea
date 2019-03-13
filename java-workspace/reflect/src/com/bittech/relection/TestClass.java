package com.bittech.relection;

import java.util.Date;

/**
 * 反射实例化对象,三种方式
 * 1.object.getClass
 * 2.类名.class直接根据某个具体的类来取得Class实例化对象
 * 3.Class.forName(String className)
 * Author:ywh
 * Date:2019/03/09
 */
public class TestClass {
    public static void main(String[] args) {
        //1.object.getClass
        Date date1 = new Date();
        Class cls = date1.getClass();

        //java.util.Date
        System.out.println("方法1 " + cls.getName());
        //class java.util.Date
        System.out.println("方法1 " + cls);

        //2.类名.class
        //一般用类的全限定名
        Class cls1 = java.util.Date.class;
        //class java.util.Date
        System.out.println("方法2 " + cls1);

        //3.推荐用
        Class cls2 = null;
        try {
             cls2 = Class.forName("java.util.Date");
            System.out.println("方法3 " + cls2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("比较三个对象");
        System.out.println(cls1 == cls);
        System.out.println(cls == cls2);


    }
}
