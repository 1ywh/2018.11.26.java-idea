package com.bittech;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**加锁，解锁
 * Author:ywh
 * Date:2019/01/17
 */
public class TestLock {
    public static void main(String[] args) {
        LockRunnable t = new LockRunnable();
        Thread thread1 = new Thread(t, "A");
        Thread thread2 = new Thread(t, "B");
        thread1.start();
        thread2.start();
    }
}

class LockRunnable implements Runnable {
    private int ticket = 10;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("----");
            lock.lock();//加锁
            try {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "还有" + --ticket + "张票");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();//一定解锁成功
            }
        }
    }
}