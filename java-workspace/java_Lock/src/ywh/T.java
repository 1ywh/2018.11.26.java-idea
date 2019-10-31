package ywh;

/**
 * @author ywh
 * @date 2019/10/28 19:58
 * @description synchronized锁对象
 */
class Test1 implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "=" + ticket--);
                }
            }
        }
    }
}
    public class T {
        public static void main(String[] args) {
            Test1 test1 = new Test1();
            new Thread(test1).start();
            new Thread(test1).start();
            new Thread(test1).start();
        }
    }
