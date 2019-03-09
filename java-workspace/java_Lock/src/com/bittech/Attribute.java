package com.bittech;

import java.lang.reflect.Field;


/**反射调用类中的属性
 * Author:ywh
 * Date:2019/03/05
 */
public class Attribute {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> m = Class.forName("com.bittech.Student");
        //取得父类中全部属性
        Field[] files = m.getFields();
        for (Field filed : files) {
            System.out.println(filed);
        }
        System.out.println("---");
        //取得父类中的指定属性
        Field files2 = m.getField("school");
        System.out.println(files2);
        System.out.println("---");
        //取得本类中的全部属性
        Field[] files3 = m.getDeclaredFields();
        for (Field f : files3) {
            System.out.println(f);
        }
        System.out.println("---");
        Object obj = m.newInstance();
        Field fi = m.getDeclaredField("school");//null
        fi.set(obj,"ii");//相当于school="ii"
        //取得属性
        System.out.println(fi.get(obj));
    }
}

class Teacher {
    public int age;
    public String name;
}

class Student extends Teacher {
    public String school;


}