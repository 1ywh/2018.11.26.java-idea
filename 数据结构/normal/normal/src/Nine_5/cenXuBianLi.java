package Nine_5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ywh
 * @date 2019/9/5 19:17
 * @description 层序遍历, offer返回add
 */
public class cenXuBianLi {
    static class Node {
        Node left;
        Node right;
        char val;

        Node(char value) {
            this.val = value;
        }
    }

    public static void c(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

        }


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
