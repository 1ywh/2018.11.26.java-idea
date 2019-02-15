package collectlist;

import java.util.LinkedList;
import java.util.Queue;

/**队列接口
 * Author:ywh
 * Date:2019/02/15
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        System.out.println(queue.peek());//A
        System.out.println(queue.poll());//A
        System.out.println(queue.poll());//B
        System.out.println(queue.poll());//C
        // 取完数据继续poll返回null
        System.out.println(queue.poll());
    }
}
