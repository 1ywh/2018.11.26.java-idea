package com.bittech.thread;

/**线程的命名、取得名字、修改名字
 * Author:ywh
 * Date:2019/03/01
 */
public class TestThread14 {
    public static void main(String[] args) {
        MyThread6 mt=new MyThread6();
        // 没有设置名字，会自动分配一个线程名字
        // 线程名字如果要设置请避免重复，同时中间不要修改
        // 这俩个执行的时候不按照顺序
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt,"java").start();
        //直接调用对象的run方法
        mt.run();
    }
}
class MyThread6 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            //修改线程的名字
            Thread.currentThread().setName("ooo");
            //取得线程名字,主线程没有继承Thread类，当然不能用里面的方法
            //但是，Thread.currentThread()是返回Thread这个对象的，所以这样就可以getName了
            System.out.println("当前线程"+Thread.currentThread().getName()+",i="+i);
        }
    }
}