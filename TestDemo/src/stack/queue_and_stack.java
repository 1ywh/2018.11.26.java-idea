package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ywh
 * @date 2019/11/12 22:41
 * @description 双队列实现栈
 */
public class queue_and_stack {
    public static void main(String[] args) {
        queue_and_stack queue = new queue_and_stack();
        queue.add1(1);
        queue.add1(2);
        queue.add1(3);

        System.out.println(queue.remove1());
        System.out.println(queue.remove1());
        System.out.println(queue.remove1());

    }

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    //当队列2时空的话就把队列1的元素放到2中
    public void add1(int n) {
        queue1.add(n);
    }

    public int remove1() {
        if (queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }

        }
        return queue2.poll();
    }
}

