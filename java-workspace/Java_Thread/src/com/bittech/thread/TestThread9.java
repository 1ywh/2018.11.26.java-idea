package com.bittech.thread;

/**锁住代码方法2.全局锁，按顺序完成
 * static synchronized方法，static方法可以直接类名加方法名调用，方法中无法使用this，
 * 因为它锁的不是this，而是类的Class对象
 * 所以，static synchronized方法也相当于全局锁，相当于锁住了代码段
 * Author:ywh
 * Date:2019/01/17
 */
public class TestThread9 {
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            Thread t=new MyThread9();
            t.setName("Thread"+i);
            t.start();//实现run方法
        }
    }
}
class Sync9{

    public  void test(){
        //全局锁synchronized（class）
        //对象锁synchronized（this|object）#优先使用
        synchronized(Sync9.class){
        System.out.println("Sync对象的Test方法执行开始："
                +Thread.currentThread().getName());
        try {
        Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync对象的Test方法执行结束:"
                +Thread.currentThread().getName());
    }
    }
}
//不共享
class MyThread9 extends Thread{

    @Override
    public void run() {
        Sync9 sync=new Sync9();
        sync.test();
    }
}