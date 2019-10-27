package com.bittech;

/**
 * @author ywh
 * @date 2019/10/27 15:46
 * @description   ThreadLocal能够相互独立
 */
class MyThread implements Runnable{

    private  ThreadLocal<String> threadLocal=new ThreadLocal<>();

    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        threadLocal.set(name);
        System.out.println(name+"获取线程的值"+threadLocal.get());

    }
}
public class TestLocal {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread, "1");
        Thread thread2 = new Thread(myThread, "2");
        Thread thread3 = new Thread(myThread, "2");
        thread1.start();
        thread2.start();
        thread3.start();
       try{
           Thread.sleep(1000);
       }catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}
