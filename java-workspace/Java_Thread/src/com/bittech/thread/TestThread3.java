package com.bittech.thread;

/**优先级
 * Author:ywh
 * Date:2019/01/17
 */
public class TestThread3 {
public void code1(){

    //1.主线程的优先级
    // System.out.println("主线程的优先级"+Thread.currentThread().getPriority());

    //2.在主线程中创建一个线程，未指定优先级 lamda表达式
    Thread threadA =new Thread(()->{
        System.out.println(Thread.currentThread().getName()
                +"优先级："+Thread.currentThread()
                .getPriority());
    },"Thread-A");
    threadA.start();
    threadA.setPriority(6);
}

    public static void main(String[] args) {


    Runnable runnable=new PriorityRunnable();
    Thread threadA =new Thread(runnable,"Thread-A");
    threadA.setPriority(Thread.MAX_PRIORITY);
    Thread threadB =new Thread(runnable,"Thread-B");
    threadB.setPriority(Thread.MIN_PRIORITY);
    Thread threadC =new Thread(runnable,"Thread-C");
    threadC.setPriority(Thread.NORM_PRIORITY);
    threadA.start();
    threadB.start();
    threadC.start();
}
}
class PriorityRunnable implements Runnable{

    @Override
    public void run() {
        Thread t=Thread .currentThread();
        System.out.println(t.getName()+"优先级"+t.getPriority());
    }
}
