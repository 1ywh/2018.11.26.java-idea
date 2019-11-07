package com.bittech;

import java.lang.reflect.Field;

/**
 * 将源对象中与目的对象相同属性，源对象的属性值copy赋值给目的对象
 * Author:ywh
 * Date:2019/01/17
 */
public class BeanCopy {
    public static void main(String[] args) {
        t a = new t();
        a.setAge(3);
        a.setName("oo");
        a.setCode(0);
        System.out.println(a);

    }

    public static void copy(Object source, Object target) {
        //1.获取class对象
        Class source1 = source.getClass();
        Class target1 = target.getClass();
        //2.获的属性对象
        Field[] s = source1.getDeclaredFields();
        Field[] t = target1.getDeclaredFields();
        //3.
        for (Field c : s) {
            for (Field d : t) {
                //源的目标字段和目标的名称、类型相等
                if (c.getName().equals(d.getName()) && c.getType() == d.getType()) {
                    //属性私有

                    try {
                        c.setAccessible(true);
                        Object o = c.get(c);
                        d.setAccessible(true);
                        d.set(target1, o);
                        //赋值
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}

class t {
    private int age;
    private String name;
    private int code;

    @Override
    public String toString() {
        return "t{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", code=" + code +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}