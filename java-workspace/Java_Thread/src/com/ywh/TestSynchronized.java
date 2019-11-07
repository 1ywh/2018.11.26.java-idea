package com.ywh;

/**
 * @author ywh
 * @date 2019/10/29 19:13
 * @description 锁对象,这样就可以代码块
 * 一个线程完了才执行另一个线程
 * begin:Thread-2
 * over:Thread-2
 * begin:Thread-1
 * over:Thread-1
 * begin:Thread-0
 * over:Thread-0
 */

class Sync {
    public void tt() {
        synchronized (this) {
            System.out.println("begin:"+Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("over:"+Thread.currentThread().getName());
        }
    }
}

class Test1 extends Thread {
    private Sync sync;

    public Test1( Sync sync) {
        this.sync = sync;
    }

   @Override
    public void run(){
        this.sync.tt();
    }
}

public class TestSynchronized {
    public static void main(String[] args) {
        Sync sync=new Sync();
        for(int i=0;i<3;i++){
            Thread test1 = new Test1(sync);
            test1.start();
        }
    }
}
