package TestSummary3;

/**
 * @author ywh
 * @date 2019/10/12 18:29
 * @description 两个有序链表的合并
 */
public class TestSummary4 {
    public static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    Node Test(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Node result = null;
        //记录链表的最后一个结点，代表整个链表
        Node last = null;
        //为了方便
        Node cur1 = l1;
        Node cur2 = l2;
        //俩个都不是空的时候合并，有一个为空的时候执行之后的程序
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                if (result == null) {
                    //result中没有结点
                    result = cur1;
                } else {
                    //result中有结点，将cur1连到result上
                    last.next = cur1;
                }
                //更新最后一个结点的记录，这样下次就可以使用last.next=cur1;
                last = cur1;
                cur1 = cur1.next;
            } else {
                Node next = cur2.next;
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }
        if (cur1 != null) {
            last.next = cur1;
        }
        if (cur2 != null) {
            last.next = cur2;
        }
        return result;
    }

    public static void print(Node head) {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.val + "->");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(2);
        Node n5 = new Node(4);
        Node n6 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        TestSummary4 t = new TestSummary4();
        Node node = t.Test(n1, n4);
        print(node);

    }
}
