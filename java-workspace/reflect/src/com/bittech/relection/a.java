package com.bittech.relection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ywh
 * @date 2019/10/17 19:34
 * @description 反射调用类中的属性
 */
class Person1 {
    private String name;
    private int age;

    public Person1() {
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class a {
    public static void main(String[] args) throws
            IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class cls4 = Class.forName("com.bittech.relection.Person1");

        // 1. 所有的普通方法必须在有实例化对象之后才可以进行调用
        //    取得一个类中全部普通方法
        Method[] method = cls4.getMethods();
        for (Method m : method) {
            System.out.println(m);
        }

        Object obj = cls4.newInstance();
        // 取得setName这个方法的实例化对象,设置方法名称与参数类型
        Method setMethod = cls4.getMethod("setName", String.class);
        // 随后需要通过Method类对象调用指定的方法，调用方法需要有实例化对象
        // 同时传入参数
        setMethod.invoke(obj, "yu"); // 相当于Person对象.setName("yuisama") ;
        Method getMethod = cls4.getMethod("getName");
        Object result1 = getMethod.invoke(obj); // 相当于Person对象.getName() ;
        System.out.println(result1);

    }
}
