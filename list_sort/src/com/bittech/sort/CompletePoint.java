package com.bittech.sort;

/**
 *
 * 在一个排序的链表中，存在重复的结点，删除该链表中重复的结点
 * 重复的结点不保留，返回链表头指针。
 * Author:ywh
 * Date:2019/04/07
 */
public class CompletePoint {
    public static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    public Node delete(Node head) {
        if (head == null) {
            return head;
        }
        Node prev1 = new Node(-1);
        prev1.next = head;
        //prev永远是 p1 的前驱结点，用来删除结点
        Node prev = prev1;
        Node p1 = head;
        Node p2 = head.next;
        while (p2 != null) {
            //方法1
            if (p2.val == p1.val) {
                //此处一直找到重复的数字
                while (p2.val == p1.val && p2 != null) {
                    p2 = p2.next;
                }
                //将重复的数字全部删除
                prev.next = p2;
                //更新p1
                p1 = p2;
                //更新p2
                if (p2 != null) {
                    p2 = p2.next;
                }
            } else {
                //当不相等的时候，一直遍历
                prev = prev.next;
                p1 = p1.next;
                p2 = p2.next;
            }
            //方法2
//            if (p1.val != p2.val) {
//                prev = prev.next;
//                p1 = p1.next;
//                p2 = p2.next;
//            } else {
//                while (p1.val == p2.val && p2 != null) {
//                    p2 = p2.next;
//                }
//                prev.next = p2;
//                p1 = p2;
//                if (p2 != null) {
//                    p2 = p2.next;
//                }
//            }
        }

        return prev1.next;

    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        CompletePoint c = new CompletePoint();
        Node node = c.delete(n1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
