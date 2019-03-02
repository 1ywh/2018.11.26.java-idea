package com.bittech.thread;

/**
 * 设置标记位使线程正常退出
 * Author:ywh
 * Date:2019/03/01
 */
public class TestThread2_1 {
    public static void main(String[] args) throws InterruptedException {
        MyThreads my = new MyThreads();
        new Thread(my, "线程A").start();
        Thread.sleep(10000);
        //设置标记位
        //my.setFlag(false);

        //stop方法
        new Thread(my, "线程A").stop();
        System.out.println("代码结束");

    }
}

class MyThreads implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 1;
        while (flag) {
            try {
                Thread.sleep(1000);
                System.out.println("第" + i + "次执行，线程名称为：" + Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}