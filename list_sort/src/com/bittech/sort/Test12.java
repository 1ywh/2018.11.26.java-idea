package com.bittech.sort;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针
 * 该指针可以指向链表中的任何结点或空结点。
 * 要求返回这个链表的深度拷贝
 * Author:ywh
 * Date:2019/04/11
 */
public class Test12 {
    public static class Node {
        private int val;

        Node(int x) {
            val = x;
        }

        //链表中任一结点的引用
        Node random;
        Node next;
    }

    public Node T(Node head) {
        //1.复制
        Node cur = head;
        while (cur != null) {
            Node newCur = new Node(cur.val);
            newCur.next = cur.next;
            cur.next = newCur;
            //走向原链表的下一个结点
            cur = cur.next.next;
        }
        //2.找random
        //cur在上一步中改变了，让cur重新指向head
        cur = head;
        while (cur != null) {
            Node newCur = cur.next;
            if (cur.random == null) {
                newCur.random = null;
            } else {
                newCur.random = cur.random.next;
            }
            //走向下一个老结点
            cur = cur.next.next;
        }
        //3.拆分
        cur = head;
        //保持新的头结点
        Node result = head.next;
        while (cur != null) {
            Node newCur = cur.next;
            cur.next = newCur.next;
            if (newCur.next != null) {
                newCur.next = newCur.next.next;
            }
            cur = cur.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        n1.random = n3;
        n2.random = n1;
        n3.random = n3;
        Test12 y = new Test12();
        Node result = y.T(n1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
