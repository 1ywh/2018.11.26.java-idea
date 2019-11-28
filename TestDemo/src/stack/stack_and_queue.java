package stack;

import java.util.Stack;

/**
 * @author ywh
 * @date 2019/11/12 22:42
 * @description
 */
public class stack_and_queue {
    public static void main(String[] args) {
        stack_and_queue a = new stack_and_queue();
        a.push(1);
        a.push(2);
        a.push(3);
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
    }

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    //出栈
    private int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //入栈
    public void push(int n) {
        stack1.push(n);
    }
}

