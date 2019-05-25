package com.bittech.tree;

import java.util.Arrays;

/**
 * 前序和中序构建二叉树
 * Author:ywh
 * Date:2019/04/18
 */
public class CreateInordorTree {
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
    //找结点
    private static Node Find(Node tree, char val){
        //1.
        if(tree==null){
            return null;
        }
        //2.
        else if(tree.val==val){
            return tree;
        }else if((Find(tree.left,val))!=null) {
            return (Find(tree.left,val));
        }
        else if((Find(tree.right,val))!=null){
            return (Find(tree.right,val));
        }
        return null;
    }

    //找到下标
    private static int findRoot(char[] tree, int val) {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == val) {
                return i;
            }
        }
        return -1;
    }

    private static Node createTree(char[] preTree, char[] inorderTree) {
        //防止下标越界
        if(preTree.length==0){
            return null;
        }

        //1.先找到根所在的位置,创建根结点
        Node root = new Node(preTree[0]);

        //2.在中序中找到根的下标
        int rootSize = findRoot(inorderTree, preTree[0]);

        //找左子树，前序中序
        char[] leftPreTree = Arrays.copyOfRange(preTree, 1, 1 + rootSize);
        char[] leftInorderTree = Arrays.copyOfRange(inorderTree, 0, rootSize);
        root.left = createTree(leftPreTree, leftInorderTree);

        //找右子树，前序中序
        char[] rightPreTree = Arrays.copyOfRange(preTree, 1 + rootSize, preTree.length);
        char[] rightInorderTree = Arrays.copyOfRange(inorderTree, 1 + rootSize, inorderTree.length);
        root.right = createTree(rightPreTree, rightInorderTree);
        return root;
    }


    public static void main(String[] args) {
        char[] preTree = new char[]{'a', 'b', 'd', 'e', 'h', 'c', 'f', 'g'};
        char[] inorderTree = new char[]{'d', 'b', 'e', 'h', 'a', 'f', 'c', 'g'};
        Node root = createTree(preTree, inorderTree);
        Find(root,'d');
    }
}
