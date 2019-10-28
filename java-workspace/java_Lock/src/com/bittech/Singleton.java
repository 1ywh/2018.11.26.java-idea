package com.bittech;

/**
 * 懒汉式1
 * Author:ywh
 * Date:2019/03/06
 */
public class Singleton {

    private static Singleton singleton;
    //私有的构造方法
    private Singleton() {
    }
    //静态的方法
    public static Singleton getInstance() {
        
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void print() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Singleton singleton = null;
        singleton = Singleton.getInstance();
        singleton.print();
    }
}
