package Nine_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ywh
 * @date 2019/9/5 17:32
 * @description 非递归前序遍历;[a, b, d, e, h, c, f, g]
 */
public class InProTree {
    static class Node {
        Node left;
        Node right;
        char val;
        Node(char value) {
            this.val = value;
        }
    }

    public static List<Character> per(Node root) {
        List<Character> list=new ArrayList<>();
        //先定义一个栈
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        //右边的cue不等于null，或者是栈为等于空的时候，每次都push一个root
        //如果不写栈为等于空的时候，内层外层cur都为空了，结束over了
        while (cur != null||!stack.empty()) {
            //左边的cur不等于null时候push
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }
            //当前结点出栈
            Node top = stack.pop();
            //指向它的右孩子
            cur = top.right;
        }
        return list;
    }

    public static void main(String[] args) {
        Node node1 = new Node('a');
        Node node2 = new Node('b');
        Node node3 = new Node('c');
        Node node4 = new Node('d');
        Node node5 = new Node('e');
        Node node6 = new Node('f');
        Node node7 = new Node('g');
        Node node8 = new Node('h');
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node8;
        node3.left = node6;
        node3.right = node7;
        System.out.println(per(node1));
    }
}
