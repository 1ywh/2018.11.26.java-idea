package stack;


import java.util.concurrent.FutureTask;

/**
 * @author ywh
 * @date 2019/11/5 8:38
 * @description  最小栈,https://leetcode-cn.com/problems/implement-queue-using-stacks/submissions/
 */

public class MinStack {

    //普通的栈

    int[] stack = new int[10];
    int i = 0;
    //最小的栈
    int[] minStack = new int[10];
    int j = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack[i++] = x;
        if (j == 0) {
            minStack[j++] = x;
        } else if (x < minStack[j - 1]) {
            minStack[j++] = x;
        }
    }

    public void pop() {
//        int i=0;
//        int j=0;
//        while(stack.length!=0){
//            for(;i<stack.length;i++,j++){
//                if (stack[i]==minStack[j]) {
//                    minStack
//                }
//            }
//        }
        if (i != 0) {
            int data = stack[--i];
            if (data == minStack[j - 1]) {
                --j;
            }
        }

    }

    public int top() {

        if (i != 0) {
            return stack[i - 1];
        }
        return -1;
    }

    public int getMin() {
        if (j != 0) {
            return minStack[j - 1];
        }
        return -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(1);
        minStack.push(-30);
//        minStack.pop();
//        System.out.println(minStack.getMin());
//        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
