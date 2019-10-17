package com.bittech.relection;

/**
 * @author ywh
 * @date 2019/10/17 19:59
 * @description  反射操作工厂模式
 */
interface A {
    void eat();
}

class A1 implements A {

    @Override
    public void eat() {
        System.out.println(1);
    }
}

class B implements A {

    @Override
    public void eat() {
        System.out.println(2);
    }
}

public class pattern {
    private pattern() {}
    public static A getInstance(String name) throws ClassNotFoundException {
        A cc = null;
        try {
            cc= (A) Class.forName(name).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return cc;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        pattern.getInstance("com.bittech.relection.A1").eat();

    }
}
