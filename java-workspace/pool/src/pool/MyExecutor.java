package pool;

import java.util.concurrent.Executor;
/**
 * @author ywh
 * @date 2019/11/12 22:37
 * @description  Executor
 */


public class MyExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

    public static void main(String[] args) {
        Executor executor = new MyExecutor();
        executor.execute(() -> System.out.println("Hello"));
    }
}

