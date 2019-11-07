package com.bittech;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ywh
 * @date 2019/10/27 16:49
 * @description newCachedThreadPool适用于任务多，执行时间短或者服务器负载比较小
 */
public class TestCachedThread {
    public static void main(String[] args) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        //缓存线程
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i = 0; i < 10_100; i++) {
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
