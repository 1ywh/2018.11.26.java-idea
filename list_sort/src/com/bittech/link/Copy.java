package com.bittech.link;

/**
 * 1.删除给定val的node
 * 2.简单复制链表,不能让cur.next=null
 * Author:ywh
 * Date:2019/04/13
 */
public class Copy {
    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //1.删除给定val的node，其实就是创造一个result如果等于就不尾插到result
    public ListNode removeElements4(ListNode head, int val) {
        //结果链表
        ListNode result = null;
        //结果链表的最后一个结点
        ListNode last = null;
        ListNode cur = head;
        while (cur != null) {
            //1.保证cur可以正常遍历的条件
            ListNode next = cur.next;
            //2.当不相等的时候开始尾插
            if (cur.val != val) {
                cur.next = null;
                if (result == null) {
                    result = cur;
                } else {
                    last.next = cur;
                }
                //3.尾插结束，更新尾结点
                last = cur;
            }
            //1.保证cur可以正常遍历的条件
            cur = next;
        }
        return result;
    }

    //2.简单复制链表
    private ListNode copyLink(ListNode head) {
        ListNode result = null;
        ListNode last = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            node.next=null;
            if (result == null) {
                result = node;
            } else {
                last.next = node;
            }
            last = node;
            cur = cur.next;
        }
        return result;
    }



    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;
        Copy c = new Copy();
        ListNode b = c.copyLink(n1);
        while (b != null) {
            System.out.println(b.val);
            b = b.next;
        }
        System.out.println();

    }
}
