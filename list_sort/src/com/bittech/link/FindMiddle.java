package com.bittech.link;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * Author:ywh
 * Date:2019/04/07
 */
public class FindMiddle {

    public static class Node {
         int val;
         Node next;

        Node(int x) {
            val = x;
        }
    }

    //使用快慢指针来写
    //快指针是慢指针的俩倍
    //快指针走俩次，满指针走一次，这是一个周期
    public Node find(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
        FindMiddle f=new FindMiddle();
        Node result=f.find(n1);
        System.out.println(result.val);
    }
}
