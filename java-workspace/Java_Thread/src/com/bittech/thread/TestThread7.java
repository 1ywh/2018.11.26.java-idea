package com.bittech.thread;

/**锁，各自完成各自的
 * Author:ywh
 * Date:2019/01/17
 */
public class TestThread7 {
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            Thread t=new MyThread();
            t.setName("Thread"+i);
            t.start();//实现run方法
        }
    }
}
class Sync{

    public synchronized void test(){
        System.out.println("Sync对象的Test方法执行开始："
                +Thread.currentThread().getName());
        try {
        Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync对象的Test方法执行结束: "
                +Thread.currentThread().getName());
    }
}
//不共享
class MyThread extends Thread{
    @Override
    public void run() {
        Sync sync=new Sync();
        sync.test();
    }
}