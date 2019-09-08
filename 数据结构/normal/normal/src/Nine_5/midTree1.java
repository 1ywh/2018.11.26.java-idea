package Nine_5;

import java.util.*;

/**
 * @author ywh
 * @date 2019/9/8 13:57
 * @description   递归中序遍历
 */
public class midTree1 {
    static class Node {
        char val;
        Node left;
        Node right;

        Node(char val) {
            this.val = val;
        }
    }

    static List<Integer> list = new ArrayList<>();

    public static List<Integer> inorderTraversal(Node root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(Integer.valueOf(root.val));
        inorderTraversal(root.right);
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
        System.out.println(inorderTraversal(node1));
    }
}

