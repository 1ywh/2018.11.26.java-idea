package com.bittech.thread;

/**
 * 线程阻塞中断interrupt和非阻塞中断
 * Author:ywh
 * Date:2019/01/17
 */
public class TestThread1 {

    public static void main(String[] args) {
        MyRunnable1 myRunnable=new MyRunnable1();
        Thread thread=new Thread(myRunnable,"子线程");
        thread.start();
        try{
            //主线程休眠
            Thread.sleep(3000);
            //调用中断
           thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyRunnable1 implements Runnable{

   private boolean flag=true;
    @Override
    public void run() {
      int i=0;
      while(this.flag){
          System.out.println(Thread.currentThread().getName()+"循环第"+ ++i+"次");
          try{

              //判断线程的中断情况
              boolean interruptStatus=Thread.currentThread().isInterrupted();

              //非阻塞中断 只是设置标记位true
              if(interruptStatus){
                  break;
              }
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
              //阻塞情况false

              // 一个线程在运行状态中，其中断标志被设置为true之后，一旦线程调用了
              // wait、join、sleep方法中的一种，立马抛出一个InterruptedException，且中断标志被程序会自动清除，重新设置为false
              System.out.println("阻塞中断"+Thread.currentThread().isInterrupted());//显示false并抛异常
              return;//不想返回还可继续写代码
          }
      }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
