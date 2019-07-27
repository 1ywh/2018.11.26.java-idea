package com.bittech.link;

/**
 * 链表的回文结构
 * Author:ywh
 * Date:2019/04/07
 */
public class ComeBack {
    public static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    //先求出链表的长度
    public int length(Node head) {
        Node cur = head;
        int len = 0;
        for (; cur != null; cur = cur.next) {
            len++;
        }
        return len;
    }
    //反转
    public Node reverse(Node head) {
        Node cur = head;
        Node result = null;
        while (cur != null) {
            //控制下一个结点
            Node next = cur.next;

            cur.next = result;
            result = cur;

            cur = next;
        }
        return result;
    }


    public boolean r(Node A) {
        int len = length(A);
        int halfLen = len / 2;
        Node middle = A;
        //找到中间的那个val
        for (int i = 0; i < halfLen; i++) {
            middle = middle.next;
        }
        //以中间的node为head开始反转，然后和A来比较
        Node ci = reverse(middle);
        while (ci != null && A != null) {
//            if (ci.val != A.val) {
//                return false;
//            }
//            ci = ci.next;
//             A = A.next;
//        }
//        return true;
            if (ci.val == A.val) {
                ci = ci.next;
                A = A.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(5);
        Node n5 = new Node(3);
        Node n6 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        ComeBack c = new ComeBack();
        System.out.println(c.r(n1));
    }

}
