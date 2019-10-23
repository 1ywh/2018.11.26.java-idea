package ThreadCom;

/**
 * @author ywh
 * @date 2019/10/22 20:23
 * @description  继承Thread类和实现Runnable类来看数据共享
 * Thread变成卖各自的票
 * Runnable是一起卖这10张票
 */
class MyThread1 extends Thread{
    private int t = 10;

    @Override
    public void run() {
        while (this.t > 0) {
            System.out.println("还剩" + this.t--);
        }
    }
}
class MyThread implements Runnable {

    private int t = 10;

    @Override
    public void run() {
        while (this.t > 0) {
            System.out.println("还剩" + this.t--);
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        //数据共享一起卖10张票
        MyThread myThread = new MyThread();

        new Thread(myThread).start();
        new Thread(myThread).start();

//        Runnable runnable = () -> System.out.println("h");
//        new Thread(runnable).start();

        //变成了卖自己的票
//        MyThread1 myThread=new MyThread1();
//        myThread.start();
//        new MyThread1().start();
    }
}
