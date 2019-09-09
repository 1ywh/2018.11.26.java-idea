package com.bittech.tree;

import java.util.List;

/**
 *  二叉树的分层遍历
 *  A(B(C)(D))(E()(F))
 * Author:ywh
 * Date:2019/04/20
 */
public class TreeString {
    public static class Node {
        Node left;
        Node right;
        char val;
        Node(char x) {
            this.val = x;
            this.right = null;
            this.left = null;
        }
    }
    //StringBuilder可变的字符串，更好
    private static void preOrderTree2Str(Node root, StringBuilder sb) {
        if (root != null) {
            sb.append('(');
            sb.append(root.val);
            if (root.left == null && root.right != null) {
                sb.append("()");
            } else {
                preOrderTree2Str(root.left, sb);
            }
            preOrderTree2Str(root.right, sb);
            sb.append(')');
        }
    }

    private static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val);
            inOrderTraversal(root.right);
        }
    }
    private static String tree2str(Node root) {
        //返回空字符串
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preOrderTree2Str(root, sb);
        sb.delete(0, 1);
        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }
    public static void main(String[] args) {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');

        a.left = b; a.right = e;
        b.left = c; b.right = d;
        e.right= f;
        String str = tree2str(a);
        System.out.println(str);
    }
}
