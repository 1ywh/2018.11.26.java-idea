package com.bittech.thread;

/**要求启动多个线程打印如下序列:
 * Author:ywh
 * Date:2019/01/17
 */
public class TestThread6 {
    public static void main(String[] args) {
        Runnable runnable=new printThread();
for(int i=0;i<10;i++){
    //由于start使用时无法控制顺序所以前面0-9不是按照顺序来
        new Thread(runnable,"Thread-"+i).start();
    }
    }
}
class printThread implements Runnable{
private int i=0;
    @Override
    //要想按照顺序来用synchronized   0-9
    public synchronized void run() {
        System.out.println("@#"+Thread.currentThread().getName()+"-"+i++);
    }
}