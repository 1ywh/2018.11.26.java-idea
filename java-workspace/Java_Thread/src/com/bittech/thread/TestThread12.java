package com.bittech.thread;

/**使用Thread实现数据共享(产生若干线程进行同一数据的处理操作)
 * 每个对象都有10张票，卖各自的票
 * Author:ywh
 * Date:2019/02/25
 */
public class TestThread12 {
    public static void main(String[] args) {
        MyThread4 myThread = new MyThread4();
        new MyThread4().start();
        new MyThread4().start();
    }
}

class MyThread4 extends Thread {
    private int ticket = 10;

    @Override
    public void run() {
        while (this.ticket > 0) {
            System.out.println("剩余车票：" + this.ticket--);
        }
    }
}
