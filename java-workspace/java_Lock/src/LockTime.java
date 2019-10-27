import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ywh
 * @date 2019/10/27 10:47
 * @description  锁
 */
class A implements Runnable {
    private Lock a = new ReentrantLock();

    @Override
    public void run() {
        test();
    }

    public void test() {

        try {
            if (a.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + "获取锁成功");
                Thread.sleep(500);
            } else {
                System.out.println(Thread.currentThread().getName() + "获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            a.unlock();
        }
        System.out.println("over");
    }
}

public class LockTime {

    public static void main(String[] args) {
        A a = new A();
        Thread thread1 = new Thread(a, "a");
        Thread thread2 = new Thread(a, "b");
        thread1.start();
        thread2.start();
    }
}
