package com.bittech.thread;

/**
 * 卖票，锁住synchronized
 * Author:ywh
 * Date:2019/01/17
 */
public class TestThread5 {
    public static void main(String[] args) {

        //共享业务逻辑
        //或者写成Runnable runnable = new TicketRunnable();
        TicketRunnable runnable = new TicketRunnable();
        Thread threadA = new Thread(runnable, "黄牛A");
        Thread threadB = new Thread(runnable, "黄牛B");
        Thread threadC = new Thread(runnable, "黄牛C");

        threadA.setPriority(Thread.MAX_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class TicketRunnable implements Runnable {

    private int ticket = 10;


//    @Override
//    //1.代码局部用同步块
//
    public void run() {
         //同一时刻，只允许一个线程进入代码块处理
        //此时输出的有一个10
        System.out.println(Thread.currentThread().getPriority());

        for (int i = 0; i < 10; i++) {
            System.out.println("--------");
            //表示为程序逻辑上锁
            synchronized (this) {//this->Runnable对象，部分锁定
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()
                                + "还有" + (this.ticket--) + "张票");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "卖完了");
    }

}
//    @Override
//    public void run() {
//  //2. 加了锁只能有一个对象进来，全部锁定,这种方法和上面的结果不同
//        //该方法只会让一个黄牛卖票
//        synchronized (this) {//this->Runnable对象
//            while (ticket > 0) {
//                    try {
//                        Thread.sleep(1000);
//                        System.out.println(Thread.currentThread().getName()
//                                + "还有" + (this.ticket--) + "张票");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println(Thread.currentThread().getName() + "卖完了");
//            }
//        }
//    }

//        @Override
//    //3.方法锁定，全部锁定，和上面那个结果相同
//    public synchronized void run() {
//        for (int i = 0; i < 10; i++) {
//            if (this.ticket > 0) {
//                try {
//                    Thread.sleep(200);
//                    System.out.println(Thread.currentThread().getName()
//                            + "还有" + (this.ticket--) + "张票");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + "卖完了");
//    }
//}
// 4.   @Override
//    public void run() {
//
//        while (this.ticket > 0) {
//            try {
//                Thread.sleep(1000);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "还有" + this.ticket-- + "张票");
//        }
//    }
//}
//同步方法，进入到方法中的线程可能为多个
//    6次执行完后在执行下一个黄牛
//    @Override
//    public void run() {
//        for (int i = 0; i < 6; i++) {
//            this.sale();
//        }
//    }
//        public synchronized void sale(){
//            if(this.ticket>0){
//                try{
//                    Thread.sleep(200);
//                }catch(InterruptedException e){
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + ",还有" + this.ticket--
//                        + " 张票");
//            }
//        }
//    }
