package thread;

/**
 * @author ywh
 * @date 2019/11/12 22:22
 * @description 创建交替线程打印1-10
 * 先打印1-10，用synchronized方法，搞一个共享变量i，此时线程不交替
 * 用唤醒和等待
 */

class MyThread implements Runnable {
    //线程共享的变量
    private int i = 1;
    //锁，每次只能一个线程进去执行
    @Override
    public synchronized void run() {
        //运行的次数为10
        while (i <= 10) {
            //这个时候另一个被唤醒，刚开始没有运行，并没有线程需要唤醒，所以直接往下运行
            notify();
            //最先运行的线程是线程1
            String threadName="线程1";
            if(i%2==0){
                threadName="线程2";
            }
            System.out.println(threadName+"--" + i++);
            try {
                //只有这种情况才等待，使线程终止wait
                if (i <= 10) {
                    //这个先等一会，别的就开始进来.也就是唤醒另一条线程打印
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class AlterThread {
    public static void main(String[] args) {
        //交替的话，先创建两个线程，启动
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread, "线程1");
        Thread t2 = new Thread(myThread, "线程2");
        t1.start();
        t2.start();
    }
}