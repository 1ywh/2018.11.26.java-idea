package com.bittech.thread;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**join方法
 * 等待该线程终止。意思就是如果在主线程中调用该方法时就会让主线程休眠
 * 让调用该方法的线程run方法先执行
 * 完毕之后在开始执行主线程。
 * Author:ywh
 * Date:2019/03/01
 */
public class TestThread18 {

    public static void main(String[] args) throws InterruptedException {
        MyThread0 mt = new MyThread0();
        Thread thread = new Thread(mt, "子线程A");
        thread.start();
        System.out.println(Thread.currentThread().getName());
        thread.join();
        System.out.println("");
    }

    public static void printTime() {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        System.out.println(time);
    }
}

class MyThread0 implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("主线程睡眠前的时间");
            TestThread18.printTime();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
            System.out.println("睡眠结束的时间");
            TestThread18.printTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
