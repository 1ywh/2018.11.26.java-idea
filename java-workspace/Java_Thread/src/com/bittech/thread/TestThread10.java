package com.bittech.thread;

/**
 * 继承Thread类实现多线程
 * Author:ywh
 * Date:2019/02/25
 */
public class TestThread10 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1("thread1");
        MyThread1 myThread2 = new MyThread1("thread2");
        //只会顺序打印，与多线程无关
//        myThread1.run();
//        myThread2.run();

        //public synchronized void start()此方法会自动调用线程的run()方法
        myThread1.start();
        myThread2.start();
    }
}

// 线程主体类,继承Thread类，覆写run（）方法
class MyThread1 extends Thread {
    private String title;

    public MyThread1(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + ",i=" + i);
        }
    }
}
