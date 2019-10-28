package ThreadCom;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author ywh
 * @date 2019/10/28 16:34
 * @description Callable
 *
 */

public class TestCallable implements Callable<String> {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new TestCallable());
        new Thread(futureTask).start();
        new Thread(futureTask).start();
    }

    private int ticket = 100;

    @Override
    public String call() throws Exception {
        while (this.ticket > 0) {
            System.out.println("还剩" + this.ticket--);
        }
        return "over";
    }

}
