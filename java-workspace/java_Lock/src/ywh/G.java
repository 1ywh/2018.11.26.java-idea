package ywh;

/**
 * @author ywh
 * @date 2019/10/28 20:13
 * @description  synchronized锁方法
 */
 class Test2 implements Runnable{
    private int ticket = 10;


    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            this.s();
        }
    }

    public synchronized void s() {
        if (ticket > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"="+ticket--);
        }
    }
}
public class G{
    public static void main(String[] args) {
        Test2 test2=new Test2();
        new Thread(test2).start();
        new Thread(test2).start();
        new Thread(test2).start();
    }

}