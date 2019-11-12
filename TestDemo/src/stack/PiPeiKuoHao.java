package stack;

import java.util.Stack;

/**
 * @author ywh
 * @date 2019/11/12 22:53
 * @description     有效的括号
 */
public class PiPeiKuoHao {

    public boolean is(String s) {
        //首先想到栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (stack.empty()) {
                stack.push(a);
            } else {
                char b = stack.peek();
                if ((b == '(' && a == ')') || (b == '{' && a == '}') || (b == '[' && a == ']')) {
                    stack.pop();
                } else {
                    stack.push(a);
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
