package com.bittech.tree;

import java.util.Arrays;


/**
 * 前序构建二叉树,带有空的标志#
 * 数组的下标
 * Author:ywh
 * Date:2019/04/18
 */

public class CreateTree {
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
    //这个类用来返回使用结点个数和根结点
   public static class Rv {
        //使用过的结点个数
        int used;
        Node returnNode;

        Rv(Node node, int used) {
            this.used = used;
            this.returnNode = node;
        }
    }

    private static Rv createTree(char[] preOrder) {
        //1和2不能交换顺序

        //1.根结点为null
        if (preOrder.length == 0) {
            return new Rv(null, 0);
        }
        //2.这是根的值利用它来创建根结点
        Node root = new Node(preOrder[0]);
        //是一个空树
        if (preOrder[0] == '#') {
            //#已经被使用了所以是1
            return new Rv(null, 1);
        } else {
            //1.左子树,利用递归
            //创建左子树，除了根结点，以后的都可能用到，所以长度-1
            char[] preLeft = new char[preOrder.length - 1];

            //数组拷贝，前闭后开，一直拷到length结束
            preLeft = Arrays.copyOfRange(preOrder, 1, preOrder.length);
//递归调用返回创建的结点和used
            Rv leftReturn = createTree(preLeft);

            //2.右子树
            //跳过
            char[] preRight = new char[preOrder.length - 1 - leftReturn.used];
            preRight = Arrays.copyOfRange(preOrder, 1 + leftReturn.used, preOrder.length);
            Rv rightReturn = createTree(preRight);

            //绑定左右子树和根
            root.left = leftReturn.returnNode;
            root.right = rightReturn.returnNode;

            return new Rv(root, leftReturn.used + 1 + rightReturn.used);

        }

    }


    public static void main(String[] args) {
        char[] preOrder = new char[]{  'A', 'B', 'C', '#', 'D', '#', '#', '#','E'};

        Rv y=createTree(preOrder);
        System.out.println(y.used);
//        Node node=y.returnNode;
//        inOrderTraversal(node);

    }
}
