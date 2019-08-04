package com.link;

/**
 * 无头的单链表
 * Author:ywh
 * Date:2019/07/24
 */
public class ILink implements ILinked {


    class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    private Node head;

    public ILink() {
        this.head = null;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node cur = this.head;
        Node node = new Node(data);
        if (cur == null) {
            this.head = node;
        } else {
            //找尾巴
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }

    }

    public void checkIndex(int index) {
        if (index < 0 || index >= getLength()) {
            throw new UnsupportedOperationException("下表不合法");
        }
    }

    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if (cur == null) {
            node.next = this.head;
            this.head = node;
        } else {
            node.next = cur.next;
            cur.next = node;
        }
        return true;

    }

    //找到index-1的位置然后就可以插入
    private Node searchIndex(int index) {
        checkIndex(index);
        Node cur = this.head;
        if (index == 0) {
            return null;
        }
        int count = 0;
        while (cur.next != null && count < index - 1) {
            count++;
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public Node searchPre(int key) {
        //返回的是删除的结点
        //如果是第一个结点
        //让cur来遍历
        Node cur = this.head;
        if (cur.data == key) {
            return this.head;
        }
        //不是第一个结点
        while (cur.next != null) {
            if (cur.next.data != key) {
                cur = cur.next;
            } else
                break;
        }
        return cur;
    }
//        while (cur.next != null) {
//            if (cur.next.data == key) {
//                return cur;
//            }
//            cur = cur.next;
//        }
//        return null;


    @Override
    public int remove(int key) {
        //找到前驱比较容易算
        Node pre = searchPre(key);
        //返回你要删的那个结点的val值
        int oldValue = 0;
        if (pre == null) {
            return -1;
        }
        //刚好是头结点
        if (pre == this.head && pre.data == key) {
            oldValue = this.head.data;
            this.head = this.head.next;
            return oldValue;
        }
        //其余的中间情况
        pre.next = pre.next.next;
        return oldValue;
    }

    @Override
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    @Override
    public int getLength() {
        int len = 0;
        Node node = this.head;
        //注意讨论当head为空的时候
        if (this.head == null) {
            return 0;
        }
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    //当node不为空的时候
    @Override
    public void display() {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    @Override
    public void clear() {
        while (this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;

        }

    }
}
