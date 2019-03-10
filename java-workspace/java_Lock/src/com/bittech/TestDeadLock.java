package com.bittech;

/**
 * 死锁，相互竞争对方的资源
 * Author:ywh
 * Date:2019/01/17
 */
public class TestDeadLock {
    //资源
    private static Pen pen = new Pen();
    //资源
    private static Book book = new Book();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (book) {
                    System.out.println(Thread.currentThread().getName() + "我有笔，我就不给你");

                    synchronized (pen) {
                        System.out.println(Thread.currentThread().getName() + "把你的本给我！");
                    }
                }
            }
        }, "ThreadA");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (pen) {
                    System.out.println(Thread.currentThread().getName() + "我有本子，我就不给你！");
                    synchronized (book) {
                        System.out.println(Thread.currentThread().getName() + "把你的笔给我！");
                    }
                }
            }
        }, "ThreadB");

        thread1.start();
        thread2.start();
    }
}

class Pen {
    private String name = "pen";

    public String getName() {
        return name;
    }
}

class Book {
    private String name = "book";

    public String getName() {
        return name;
    }
}