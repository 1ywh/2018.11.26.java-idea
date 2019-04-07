package com.bittech.sort;


/**
 * 链表
 * 头插、尾插
 * 头删、尾删
 * 链表的反转
 * 链表的遍历打印
 * <p>
 * Author:ywh
 * Date:2019/03/31
 */
public class Link {

    //链表中的第一个结点
    public static class Node {
        //下个结点的索引
        public Node next;
        //保存的有效数字
        public int value;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    //一个结点都没有
    Link() {
        this.head = null;
    }

    //1.头插,O(1)
    public void pushFront(Node node) {
        node.next = this.head;
        this.head = node;
    }

    //2.尾插O(1)
    public void pushBack(Node node) {

        Node cur = this.head;
        if (this.head == null) {
            this.head = node;
        }
        cur = getLast();
        cur.next = node;

    }

    //3.得到最后一个元素
    private Node getLast() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    //4.头删O(1)
    public void popFront(Node node) {
        if (this.head == null) {
            throw new Error();
        }
        this.head = this.head.next;
    }

    //5.尾删O(n)
    public void popBack(Node node) {
        if (this.head == null) {
            throw new Error();
        }
        if (this.head.next == null) {
            this.head = null;
        }
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
    }

    //链表的打印
    public void disPlay() {

        Node cur = this.head;

        while (cur != null) {
            System.out.format(cur.value + "->");
            cur = cur.next;
        }
        System.out.println(cur = null);
    }

    //链表的反转
    public Node reverse() {
        Node cur = this.head;
        Node result = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }


    public static void main(String[] args) {
        Link link = new Link();
        link.pushFront(new Node(1));
        link.pushFront(new Node(2));
        link.pushFront(new Node(3));
        System.out.println(link.head.value);
        link.disPlay();
        Node result = link.reverse();

        while (result != null) {
            System.out.format(result.value + "->");
            result = result.next;
        }
        System.out.println(result = null);
    }
}
