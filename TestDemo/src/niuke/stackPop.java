package niuke;

import java.util.Stack;

/**
 * @author ywh
 * @date 2019/12/7 17:16
 * @description  剑指offer
 */
public class stackPop {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            s1.push(pushA[i]);
            if (s1.peek() == popA[j]) {
                s2.push(s1.pop());
                j++;
            }
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        for (int i = popA.length - 1; i >= 0; i--) {
            if (s2.pop() != popA[i]) {
                return false;
            }
        }
        return true;
    }
}
