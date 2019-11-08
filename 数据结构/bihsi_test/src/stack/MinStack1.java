package stack;

import java.util.Stack;

/**
 * @author ywh
 * @date 2019/11/5 9:15
 * @description 最小栈：https://leetcode-cn.com/problems/min-stack/solution
 */
public class MinStack1 {
    //s1表示正常栈，s2表示每一次的最小值，辅助作用
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        //1.元素入栈s1
        s1.push(x);
        //2.如果s2为空的话，入s2
        if (s2.isEmpty()) {
            s2.push(x);
        }
        //不为空的话比较大小,s2栈顶中现在存放的是上一次的最小值
        //保存最小值
        int min = s2.peek();
        if (min > x) {
            min = x;
        }
        s2.push(min);
    }

    public void pop() {
        if (s1.isEmpty()) {
            return;
        }
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

    public static void main(String[] args) {

    }
}
