package com.bittech.tree;

import jdk.nashorn.internal.ir.ReturnNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
 * Author:ywh
 * Date:2019/04/24
 */
public class CommonRoot {
    private static class Node {
        Node left;
        Node right;
        char val;

        Node(char val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    //看你的根结点是不是在左子树或者是在右子树
    public boolean isRoot(Node root, Node t) {
        if (root == null) {
            return false;
        }
        if (root == t) {
            return true;
        }
        //看左子树中有没有这个结点
        if (isRoot(root.left, t)) {
            return true;
        }
        //看右子树中有没有这个结点
        if (isRoot(root.right, t)) {
            return true;
        }
        return false;
    }

    public Node ReturnRoot(Node root, Node p, Node q) {
        //最近的祖先
        if (q == root || p == root) {
            return root;
        }
        //先假设他们都在左子树
        boolean n1 = isRoot(root.left, p);
        boolean n2 = isRoot(root.left, q);
        //如果都在了，则在左子树中寻找
        if (n1 && n2) {
            return ReturnRoot(root.left, p, q);
        }
        //此时是在右子树中寻找
        if (!n1 && !n2) {
            return ReturnRoot(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        e.left = b;
        e.right = g;
        b.left = a;
        b.right = d;
        d.left = c;
        g.left = f;
        g.right = h;
        CommonRoot mm = new CommonRoot();
        Node node = mm.ReturnRoot(e, a, c);
        System.out.println(node.val);
    }


}
