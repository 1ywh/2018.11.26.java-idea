package com.bittech.sort;

/**
 * 删除重复结点
 * 当p2！=null时循环
 * Author:ywh
 * Date:2019/04/20
 */
public class deletePoint {
    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //删除重复结点
    private static ListNode drop1(ListNode head) {
        ListNode h1 = head;
        ListNode h2 = head.next;
        ListNode prev1 = new ListNode(-1);
        prev1.next=head;
        if(head == null){
            return null;
        }
        while (h2 != null) {
            if (h1.val == h2.val) {
                while (h2!=null&&h1.val == h2.val) {
                    h2 = h2.next;
                }
                if (h2 == null) {
                    prev1.next = h2;
                } else {
                    prev1.next = h2;
                    h1 = h2;
                    h2 = h2.next;
                }
            } else {
                prev1 = h1;
                h1 = h1.next;
                h2 = h2.next;
            }
        }
        return head;
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
        ListNode d = deletePoint.drop1(n1);
        while (d != null) {
            System.out.println(d.val);
            d = d.next;
        }
    }
}
