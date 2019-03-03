package com.bittech.thread;

/**锁住代码方法1.对象锁，有顺序的完成
 * Author:ywh
 * Date:2019/01/17
 */
public class TestThread8 {
    public static void main(String[] args) {
        Sync2 sync2=new Sync2();
        for(int i=0;i<3;i++){
            Thread t=new MyThread2(sync2);
            t.setName("Thread-"+i);
            t.start();//实现run方法
        }
    }
}
class Sync2{
////1.synchronized同步的是Sync2同一个对象的方法非静态，锁得就是对象本身也就是this
//    public synchronized void test(){
//        System.out.println("Sync对象的Test方法执行开始："
//                +Thread.currentThread().getName());
//        try {
//        Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Sync对象的Test方法执行结束: "
//                +Thread.currentThread().getName());
//    }

    //2.锁得是同一个对象
 public  void test(){
    synchronized(this){
    System.out.println("Sync对象的Test方法执行开始:"
            +Thread.currentThread().getName());
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Sync对象的Test方法执行结束:"
            +Thread.currentThread().getName());
}
}
}
//不共享
class MyThread2 extends Thread{
    private final Sync2 sync;

    MyThread2(Sync2 sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        sync.test();
    }
}