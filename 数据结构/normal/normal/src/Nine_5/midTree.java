package Nine_5;

import java.util.Stack;

/**
 * @author ywh
 * @date 2019/9/5 18:00
 * @description 中序遍历非递归;d b e h a f c g
 */
public class midTree {
    static class Node {
        Node left;
        Node right;
        char val;

        Node(char value) {
            this.val = value;
        }
    }

    public static Node c(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
            System.out.print(top.val+" ");
        }
        return root;
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
        c(node1);
    }
}
