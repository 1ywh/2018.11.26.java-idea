package com.bittech;

/**wait、notify、notifyAll方法
 * Author:ywh
 * Date:2019/03/03
 */
public class Wait {
    public static void main(String[] args) throws InterruptedException {
//        Object object=new Object();
//        synchronized(object){
//            System.out.println("等待中");
//            object.wait();
//            System.out.println("等待已过");
//        }
//        System.out.println("main方法结束");
//        Object obj = new Object();
//        MThread waitThread = new MThread(true, obj);
//        MThread notifyThread = new MThread(false, obj);
//        Thread thread1 = new Thread(waitThread, "wait线程");
//        Thread thread2 = new Thread(notifyThread, "notify线程");
//        thread1.start();
//        Thread.sleep(1000);
//        thread2.start();
//
        Object object = new Object();
        MThread waitThread1 = new MThread(true, object);
        MThread waitThread2 = new MThread(true, object);
        MThread waitThread3 = new MThread(true, object);
        MThread notifyThread = new MThread(false, object);
        Thread thread1 = new Thread(waitThread1, "wait线程A");
        Thread thread2 = new Thread(waitThread2, "wait线程B");
        Thread thread3 = new Thread(waitThread3, "wait线程C");
        Thread thread4 = new Thread(notifyThread, "notify线程");
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(1000);
        thread4.start();
        System.out.println("main方法结束!!");

    }
}

class MThread implements Runnable {
    private boolean flag;
    private Object obj;


    public MThread(boolean flag, Object obj) {
        super();
        this.flag = flag;
        this.obj = obj;
    }

    public void waitMethod() {
        synchronized (obj) {
            try {
                while (true) {
                    System.out.println("wait方法开始" + Thread.currentThread().getName());
                    obj.wait();
                    System.out.println("wait()方法结束.. " +
                            Thread.currentThread().getName());
                    return;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void notifyMethod() {
        synchronized (obj) {
            try {
                System.out.println("notify()方法开始.. " +
                        Thread.currentThread().getName());
              //  obj.notify();
                obj.notifyAll();
                System.out.println("notify()方法结束.. " +
                        Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        if (flag) {
            this.waitMethod();
        } else {
            this.notifyMethod();
        }
    }
}