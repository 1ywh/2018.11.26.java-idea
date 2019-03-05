package com.bittech;

import java.lang.reflect.Field;

/**
 * 反射封装
 * 1. 设置属性内容 : public void set(Object obj, Object value) throws IllegalArgumentException, IllegalAccessException
 * 2. 取得属性内容 : public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException
 * 3.取得属性类型 ：public Class<?> getType()
 * Author:ywh
 * Date:2019/03/05
 */
public class Encapsulate {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Class<?> cls5 = Class.forName("com.bittech.Friend1");
        //实例化本类对象
        Object obj = cls5.newInstance();
        //操作name属性
        Field field0 = cls5.getDeclaredField("name");

        //设置属性内容,等价于对象.name="ii"，设置封装,运行的时候会出错
        //field0.set(obj, "ii");
        //取消封装
        field0.setAccessible(true);
        field0.set(obj, "i");

        //取得属性内容
        System.out.println(field0.get(obj));
        //包.类
        System.out.println(field0.getType().getName());
        //类名称
        System.out.println(field0.getType().getSimpleName());
    }
}

class Friend1 {
    private String name;
}