package com.bittech.tree;

import java.util.Arrays;
import java.util.List;

/**
 * 利用中序和后续创建二叉树
 * Author:ywh
 * Date:2019/04/19
 */
public class CreateBankTree {
    public static class Node {

        Node left;
        Node right;
        char val;

        Node( char val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }
    }
    //找
    public static Node Find(Node root, char val) {
        //1.
        if (root == null) {
            return null;
        }
        //2.
        if (root.val == val) {
            return root;
        }
        if ((Find(root.left, val)) != null) {
            return Find(root.left, val);
        }
        return Find(root.right, val);
    }

    //找到下标
    public static int findRoot(char[] tree, int val) {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static Node createTree(char[] inorderTree, char[] bankTree) {

        if (inorderTree.length == 0) {
            return null;
        }
        Node root = new Node(bankTree[bankTree.length - 1]);
        int rootSize = findRoot(inorderTree, bankTree[bankTree.length - 1]);

        //找左子树
        char[] leftBankTree = Arrays.copyOfRange(bankTree, 0,  rootSize);
        char[] leftInorderTree = Arrays.copyOfRange(inorderTree, 0, rootSize);
        root.left = createTree(leftBankTree, leftInorderTree);

        //找右子树
        char[] rightBankTree = Arrays.copyOfRange(bankTree,rootSize, bankTree.length-1);
        char[] rightInorderTree = Arrays.copyOfRange(inorderTree, 1 + rootSize, inorderTree.length);
        root.right = createTree(rightBankTree, rightInorderTree);
        return root;
    }

    public static void main(String[] args) {
        char[] bankTree = new char[]{'d', 'h', 'e', 'b', 'f', 'g', 'c', 'a'};
        char[] inorderTree = new char[]{'d', 'b', 'e', 'h', 'a', 'f', 'c', 'g'};
        Node root = createTree(inorderTree,bankTree);
        Find(root,'d');
    }
}
