package com.ywh;

/**
 * @author ywh
 * @date 2019/10/29 19:23
 * @description 让synchronized锁这个类对应的Class对象, 全局锁
 * test方法开始，当前线程为 Thread-2
 * test方法结束，当前线程为 Thread-2
 * test方法开始，当前线程为 Thread-1
 * test方法结束，当前线程为 Thread-1
 * test方法开始，当前线程为 Thread-0
 * test方法结束，当前线程为 Thread-0
 */
class Sync1 {
    public static synchronized void test1() {
       // synchronized (Sync1.class) {
            System.out.println("test方法开始，当前线程为 " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test方法结束，当前线程为 " + Thread.currentThread().getName());
        }
    }

//}

class TestSync extends Thread {

    @Override
    public void run() {
        Sync1 sync1 = new Sync1();
        sync1.test1();
    }
}

public class TestSynchronized2 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new TestSync().start();
        }
    }

}
