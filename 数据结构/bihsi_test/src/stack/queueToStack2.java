package stack;

import java.util.LinkedList;

/**
 * @author ywh
 * @date 2019/11/4 14:33
 * @description   双列实现栈，https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class queueToStack2 {

    //A是用来入栈的，B始终是空的（辅助操作）
    private LinkedList<Integer> A;
    private LinkedList<Integer> B;

    /**
     * Initialize your data structure here.
     */
    public queueToStack2() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        A.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        //空栈
        if (A.isEmpty()) {
            return 0;
        }
        while (A.size() > 1) {
            int cur = A.removeFirst();
            B.addLast(cur);
        }
        //最终出栈的元素
        int ret = A.removeFirst();
        LinkedList<Integer> temp = A;
        A = B;
        B = temp;
        return ret;
    }

    /**
     * Get the top element.
     */
    public int top() {
        //空栈
        if (A.isEmpty()) {
            return 0;
        }
        while (A.size() > 1) {
            int cur = A.removeFirst();
            B.addLast(cur);
        }
        //最终出栈的元素
        int ret = A.removeFirst();
        B.addLast(ret);
        LinkedList<Integer> temp = A;
        A = B;
        B = temp;
        return ret;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return A.isEmpty();
    }
}
