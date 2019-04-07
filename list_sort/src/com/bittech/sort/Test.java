package com.bittech.sort;

/**
 * 删除链表中等于给定值 val 的所有节点
 * 另找一个空链表，逐个遍历原链表,找到val则不尾插到新链表，跳过val
 * 没找到就尾插到新链表上
 * 有三种方法
 * Author:ywh
 * Date:2019/04/06
 */
public class Test {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //方法1
    public ListNode removeElements1(ListNode head, int val) {
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

    //方法2
    public ListNode removeElements2(ListNode head, int val) {
        //结果链表
        ListNode result = null;
        //结果链表的最后一个结点
        ListNode last = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == val) {
               //啥也不干
            } else {
                if (result == null) {
                    result = cur;
                } else {
                    last.next = cur;
                }
                last = cur;
            }
            cur = next;
        }
        return result;
    }

    //方法3
    //这个方法和前俩种方法不太一样，前俩种方法都是创建新链表
    //这个方法直接在原链表上进行操作
    public ListNode removeElements3(ListNode head, int val) {

        ListNode cur = head;
        if (head == null) {
            return null;
        }
        //1.先从head.next开始遍历，忽略了head
        while (cur.next != null) {
            if (cur.next.val != val) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        //2.如果head.val==val，则返回head之后的链表
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }

}

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;
        Test t = new Test();
        ListNode result1 = t.removeElements1(n1, 6);
        ListNode result = t.removeElements2(n1, 6);
        ListNode result2 = t.removeElements3(n1, 6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
