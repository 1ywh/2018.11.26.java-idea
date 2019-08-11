package com.bittech.link;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * Author:ywh
 * Date:2019/04/07
 */
public class FindLast {
    public static class Node {

        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    public Node find(Node head, int k) {
        Node front = head;
        Node back = head;
        int i;
        //先遍历找到那个front，此时分俩类讨论
        for (i = 0; front != null && i < k; i++) {
            front = front.next;
        }
        //1.k大于结点的个数,导致i<k,但是此时front==null
        if (front == null && i < k) {
            return null;
        }
        //2.正常情况下i++之后i==k
        //是因为front==null结束的，此时要找的就是头结点
        else if (front == null&&i==k) {
            return head;
        }
        //3.back从head开始
        //front从if语句结束时的front开始遍历
        //俩个相互交错
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        return back;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(6);
        Node n4 = new Node(3);
        Node n5 = new Node(4);
        Node n6 = new Node(5);
        Node n7 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;
        FindLast f = new FindLast();
        Node r = f.find(n1, 9);
        System.out.println(r.val);
    }
}
