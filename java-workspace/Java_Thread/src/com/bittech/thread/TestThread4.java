package com.bittech.thread;

/**守护线程
 * Author:ywh
 * Date:2019/01/17
 */
public class TestThread4 {
    public static void main(String[] args) {
        //1.不是守护线程是用户定义的线程
        //当我们的用户线程存在就工作，用户线程不存在则停止,来守护用户线程
        //System.out.println(Thread.currentThread().isDaemon());

        //线程A
        Thread threadA = new Thread(new DaemonRunnable(),"子线程A");
        // 设置线程A为守护线程，此语句必须在start方法之前执行
        //没有的话程序一直进行
        threadA.setDaemon(true);
        threadA.start();

        //线程B用户线程
        Thread threadB = new Thread(new DaemonRunnable(),"子线程B");
        threadB.start();

        //主线程
        try {
            Thread.sleep(3000);
        // 中断用户线程
            threadB.interrupt();
            //main为用户线程，此时未结束，所有用户线程都结束后 守护线程结束
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DaemonRunnable implements Runnable{

    @Override
    public void run() {
        int i=0;
        try{
        while(true){
            System.out.println(Thread.currentThread().getName()+"调用第"+ ++i+"次");
            Thread.sleep(1000);
        }
        }catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"中断");
        }
    }
}
