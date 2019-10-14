package one;

import java.util.ArrayList;
import java.util.Stack;

/*
* 从头到尾打印链表
* 返回的是List
*
* */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class S1 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) {
            return list;
        }
//        //先反转
//        ListNode node2 = listNode;
//        ListNode node = node2;
//        while (listNode.next != null) {
//            ListNode node1 = listNode.next;
//            listNode.next = node1.next;
//            node1.next = node2;
//            node2 = node1;
//        }
//        node.next = null;
//        while (node2 != null) {
//            list.add(node2.val);
//            node2 = node2.next;
//
//        }
        //用栈
        Stack<Integer> stack=new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while(!stack.empty()){
           list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(15);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(printListFromTailToHead(node));
    }
}