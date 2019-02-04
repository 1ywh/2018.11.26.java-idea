package com.bittech.thread;

/**
 * 线程两种方法停止
 * Author:ywh
 * Date:2019/01/17
 */
public class TestThread2 {

    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread thread=new Thread(myRunnable,"子线程");
        thread.start();
        try{
            //主线程休眠
            Thread.sleep(3000);
            //1.修改标记位
            //myRunnable.setFlag(false);
            //2.直接用stop
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
      int i=0;
      while(true){
          System.out.println(Thread.currentThread().getName()+"循环第"+ ++i+"次");
          try{
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }
}
