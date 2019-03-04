package com.bittech;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**反射取得包名称、父类名称、全部构造方法等
 * Author:ywh
 * Date:2019/03/04
 */
interface IFruit1{}
interface IMessage{}
class CLS implements IFruit1,IMessage{}
class Person{
    public Person(){}
    public Person(String name){}
    public  Person(String name,int age){}

}
public class SuperClass {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls=CLS.class;
        //取得包名称
        System.out.println(cls.getPackage().getName());
        //取得父类的名称
        System.out.println(cls.getSuperclass().getName());
        //取得实现的父接口对象
        Class<?>[] iClass=cls.getInterfaces();
        for(Class<?> class1:iClass){
            System.out.println(class1.getName());
        }
        System.out.println("---");
        //取得类中的全部构造
        Class<?> cls1=Person.class;
        Constructor<?>[] constructors=cls1.getConstructors();
        for(Constructor<?> constructor :constructors){
            //只返回包名和类名
            System.out.println(constructor.getName());
            //返回构造方法的全部信息
            System.out.println(constructor);
        }
        System.out.println("----");
        //取得指定参数类型的构造方法对象
        Constructor<?> cons=cls1.getConstructor(String.class,int.class);
        System.out.println(cons.newInstance("yu",23));
    }
}
