package com.bittech;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ywh
 * @date 2019/10/27 17:14
 * @description  延迟执行任务，周期性执行任务
 */
public class TestScheduled {
    public static void main(String[] args) {
        ScheduledExecutorService  e=Executors.newScheduledThreadPool(5, new ThreadFactory() {
          private  final AtomicInteger atomicInteger=new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                thread.setName("调度任务"+atomicInteger.getAndAdd(1));
                return thread;
            }
        });
        e.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("this1-"+Thread.currentThread().getName());
            }

        },1,TimeUnit.SECONDS);
        e.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("this2-"+LocalDateTime.now().toString()+" "+Thread.currentThread().getName());
            }
        },1,2,TimeUnit.SECONDS);
        e.shutdown();
    }
}
