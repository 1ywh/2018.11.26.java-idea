package TestSummary2;

import Eight_15.Person;

import java.util.Scanner;

/**
 * @author ywh
 * @date 2019/10/10 17:06
 * @description 代理设计模式
 * 俩个类使用同一个接口
 */

interface a {
    void eat();
}

//真正的业务
class a1 implements a {

    @Override
    public void eat() {
        System.out.println("主要是吃顿饭");
    }
}

//代理的业务
class a2 implements a {
    private a a;

    //构造方法为铺垫，使用它调用eat()方法
    public a2(a a) {
        this.a = a;
    }

    @Override
    public void eat() {
        System.out.println("1");
        this.a.eat();
        System.out.println("2");
    }
}

//这个方法可以使主方法的实例化变得简单
class Proxy_Factory {
    public static a get() {
        return new a2(new a1());
    }

}

public class ProxyTest {
    public static String firstUpper(String str) {
        //判断是不是空的
        if ("".equals(str) || str == null) {
            return str;
        } else if (str.length() <= 1) {
            return str.toUpperCase();
        } else return str.substring(0, 1).toUpperCase().concat(str.substring(1));
    }


    public static void main(String[] args) {
//        a2 a = new a2(new a1());
//        a.eat();
        a a = Proxy_Factory.get();
        a.eat();
    }
}
