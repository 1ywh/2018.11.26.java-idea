package com.bittech.thread;

/**
 * Runnable()接口实现多线程
 * Thread类的核心功能是进行线程的启动。
 * 如果一个类为了实现多线程直接去继承Thread类就会有单继承局限。
 * 利用Runnable实现数据共享只卖10张票
 * Author:ywh
 * Date:2019/02/25
 */
public class TestThread11 {
    public static void main(String[] args) {

        MyThread3 myThread1 = new MyThread3();
        new Thread(myThread1).start();
        new Thread(myThread1).start();

        //使用匿名内部类进行Runnable对象创建
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();

        //使用Lambda表达式进行Runnable对象创建
        Runnable runnable = () -> System.out.println("hello");
        new Thread(runnable).start();
    }
}

class MyThread3 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while (this.ticket > 0) {
            System.out.println("剩余票数：" + this.ticket--);
        }
    }
}
