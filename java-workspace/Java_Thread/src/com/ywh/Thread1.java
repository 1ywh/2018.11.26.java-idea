package com.ywh;

/**
 *卖票机制,是不同步的,不同步的速度快，多个线程并发进行
 * C卖了9
 * A卖了8
 * B卖了10
 * C卖了7
 * B卖了6
 * A卖了5
 * C卖了4
 * B卖了2
 * A卖了3
 * B卖了1
 * A卖了1
 * C卖了0
 * Author:ywh
 * Date:2019/08/05
 */
public class Thread1 implements Runnable {
    private int ticket = 10;


    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        new Thread(thread1, "A").start();
        new Thread(thread1, "B").start();
        new Thread(thread1, "C").start();

    }

    @Override
    public void run() {
        while(ticket>0){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖了"+this.ticket--);
        }
    }
}
