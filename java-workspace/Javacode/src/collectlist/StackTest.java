package collectlist;

import java.util.Stack;

/**栈
 * Author:ywh
 * Date:2019/02/15
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.push("A");
        stack.push("B");
        stack.push("C");
        //观察出入栈操作,C
        System.out.println(stack.peek());
        System.out.println(stack.pop());//C
        System.out.println(stack.pop());//B
        System.out.println(stack.pop());//A
        //如果栈已经空了，那么再次出栈就会抛出空栈异常,java.util.EmptyStackException
        //System.out.println(stack.pop());

    }
}


