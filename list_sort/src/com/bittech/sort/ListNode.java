package com.bittech.sort;

/**
 *
 * 以给定值x为基准将链表分割成两部分
 * 所有小于x的结点排在大于或等于x的结点之前
 * 链表之前的顺序没有改变
 * Author:ywh
 * Date:2019/04/06
 */
public class ListNode {
    public static class Node {
        int val;
        Node next = null;

        Node(int x) {
            val = x;
        }
    }

    public Node All(Node head, int x) {
        //小于x
        Node small = null;
        //小于x的最后一个结点
        Node smallLast = null;
        //大于x
        Node big = null;
        //大于x的最后一个结点
        Node bigLast = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = null;
            //小于的情况
            if (cur.val <= x) {
                if (small == null) {
                    small = cur;
                } else {
                    smallLast.next = cur;
                }
                //更新最后一个结点记录
                smallLast = cur;
            } else {
                //大于的情况
                if (big == null) {
                    big = cur;
                } else {
                    bigLast.next = cur;
                }
                //更新最后一个结点记录
                bigLast = cur;
            }
            cur = next;
        }
        //考虑有链表为空的情况
        if (small == null) {
            return big;
        } else {
            smallLast.next = big;
            return small;
        }
//        //此代码是没有写cur.next=null的时候
//        if (small == null&&big!=null) {
//            bigLast.next = null;
//            return big;
//        }
//
//        if(small!=null&&big!=null){
//            smallLast.next = big;
//            bigLast.next=null;
//            return small;
//        }
//        else{
//            smallLast.next=null;
//            return small;
//        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(6);
        Node n5 = new Node(2);
        Node n6 = new Node(8);
        Node n7 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;
        ListNode l = new ListNode();
        Node result = l.All(n1, 5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
