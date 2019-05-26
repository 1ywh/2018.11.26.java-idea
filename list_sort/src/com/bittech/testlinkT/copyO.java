package com.bittech.testlinkT;

/**
 * Author:ywh
 * Date:2019/04/20
 */
public class copyO {
    public static class Node {
        int val;
        Node next;

        Node random;

        Node(int x) {
            val = x;
        }

    }

    public Node a(Node head, int v) {
        Node node = new Node(v);
        node.next = head;
        head = node;
        return head;
    }

    public Node copy(Node head) {
        //1.复制
        Node cur = head;
        while (cur != null) {
            Node n = new Node(cur.val);
            n.next = cur.next;
            cur.next = n;
            cur = cur.next.next;
        }
        //2.random
        cur = head;
        while (cur != null) {
            Node n =cur.next;
            if (cur.random == null) {
                n.random=null;
            } else {
                n.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //3.返回数组
        cur = head;
        Node result = cur.next;
        while (cur != null) {
            cur.next = result.next;
            if( result.next!=null){
                result.next = result.next.next;
            }

            cur = cur.next;
        }

        return result;

    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        n1.random = n3;
        n2.random = n1;
        n3.random = n3;
        copyO c = new copyO();
        Node n = c.copy(n1);
        for (; n != null; n = n.next) {
            System.out.println(n.val);
        }
    }
}
