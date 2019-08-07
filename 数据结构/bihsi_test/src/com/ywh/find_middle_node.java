package com.ywh;

/**
 * kankan
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 * Author:ywh
 * Date:2019/07/28
 */
public class find_middle_node {
    public static void main(String[] args) {

    }
    class Node {
        Node next;
        int data;
        Node(int data){
            this.data=data;
        }
    }
    public Node middleNode(Node head) {
        Node cur = head;
        int len = 0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        cur=head;
        for (int i = 0; i < len/2; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
