package com.bittech;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ywh
 * @date 2019/10/27 16:17
 * @description   newFixedThreadPool用于负载比较高的时候
 */
public class TestFixThread {
    public static void main(String[] args) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        //固定容量的线程池
        ExecutorService e = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            e.submit(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "="+atomicInteger.getAndAdd(1));
                }
            });

        }
        e.shutdown();
    }
}
