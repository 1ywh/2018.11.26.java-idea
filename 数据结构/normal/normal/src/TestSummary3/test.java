package TestSummary3;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class test {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) {
            return list;
        }
        //先反转
        ListNode node2 = listNode;
        ListNode node = node2;
        while (listNode.next != null) {
            ListNode node1 = listNode.next;
            listNode.next = node1.next;
            node1.next = node2;
            node2 = node1;
        }
        node.next = null;
        while (node2 != null) {
            list.add(node2.val);
            node2 = node2.next;

        }
        return list;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(15);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=null;
        System.out.println(printListFromTailToHead(node));
    }
}