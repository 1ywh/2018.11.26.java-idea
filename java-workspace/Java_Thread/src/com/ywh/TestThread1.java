package com.ywh;

/**
 * @author ywh
 * @date 2019/11/5 15:34
 * @description   锁的当前对象Sync，不是代码块
 * 线程1进入test，线程2不能进入test2
 */
//class Sync22 {
//    public synchronized void test1() {
//        if (Thread.currentThread().getName().equals("A")) {
//            while (true) {
//            }
//        }
//    }
//    public synchronized void test2() {
//        if (Thread.currentThread().getName().equals("B")) {
//            System.out.println("线程B打印方法");
//        }
//    }
//}
//class My implements Runnable {
//    private Sync22 sync;
//
//    public My(Sync22 sync) {
//        this.sync = sync;
//    }
//    @Override
//    public void run() {
//        this.sync.test1();
//        this.sync.test2();
//    }
//}
//
//public class TestThread1 {
//
//    public static void main(String[] args) {
//        Sync22 sync22 = new Sync22();
//        My my = new My(sync22);
//        Thread thread1 = new Thread(my, "A");
//        Thread thread2 = new Thread(my, "B");
//        thread1.start();
//        thread2.start();
//    }
//}
public class TestThread1 {

    public static void main(String[] args) {
        MyRunnable1 myRunnable=new MyRunnable1();
        Thread thread=new Thread(myRunnable,"子线程");
        thread.start();
        try{
            //主线程休眠
            Thread.sleep(3000);
            //调用中断，true
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyRunnable1 implements Runnable{

    @Override
    public void run() {
        int i=0;
        while(true){
            try{

                //判断线程的中断情况
                boolean interruptStatus=Thread.currentThread().isInterrupted();
                System.out.println(Thread.currentThread().getName()+"循环第"+ ++i+"次"+interruptStatus);
                Thread.sleep(1000);
                //非阻塞中断 只是设置标记位true
                if(interruptStatus){
                    //如果中断为true则退出
                    break;
                }

            } catch (InterruptedException e) {

                // 一个线程在运行状态中，其中断标志被设置为true之后，一旦线程调用了
                // wait、join、sleep方法中的一种，立马抛出一个InterruptedException，且中断标志被程序会自动清除，重新设置为false
                System.out.println("阻塞中断"+Thread.currentThread().isInterrupted());//显示false并抛异常
                return;//不想返回还可继续写代码
            }
        }
    }

}