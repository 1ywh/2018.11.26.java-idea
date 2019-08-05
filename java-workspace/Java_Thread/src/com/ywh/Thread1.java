package com.ywh;

/**
 *��Ʊ����,�ǲ�ͬ����,��ͬ�����ٶȿ죬����̲߳�������
 * C����9
 * A����8
 * B����10
 * C����7
 * B����6
 * A����5
 * C����4
 * B����2
 * A����3
 * B����1
 * A����1
 * C����0
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
            System.out.println(Thread.currentThread().getName()+"����"+this.ticket--);
        }
    }
}
