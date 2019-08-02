package com.ywh;

/**
 * 删除重复结点
 * Author:ywh
 * Date:2019/07/27
 */
public class deleteNode {
    class Node {
        private Node next;
        private int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void addFirst(int data) {
        Node cur = new Node(data);
        if (this.head == null) {
            this.head = cur;
        } else {
            cur.next = this.head;
            this.head = cur;
        }

    }

    public void display() {
        Node cur = this.head;
        for (; cur != null; cur = cur.next) {
            System.out.println(cur.data);
        }
    }

    public Node deleteNode() {
        //用来遍历
        Node cur = this.head;
        //一个头结点
        Node node = new Node(-1);
        //用来保存第一个不重复的结点
        Node pHead = node;
        while (cur != null) {
            //重复结点
            if (cur.next != null && cur.next.data == cur.data) {
                //一直遍历往后找
                while (cur.next != null && cur.next.data == cur.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                pHead.next = cur;
            } else {
                //已经确定了不是重复的结点
                pHead.next = cur;
                pHead = cur;
                cur = cur.next;
            }
        }
        //pHead一直在变化
        return node.next;
    }

    public static void main(String[] args) {
        deleteNode deleteNode = new deleteNode();
        deleteNode.addFirst(1);
        deleteNode.addFirst(2);
        deleteNode.addFirst(2);
        deleteNode.addFirst(4);
        deleteNode.display();
        deleteNode.deleteNode();
        deleteNode.display();
    }
}
