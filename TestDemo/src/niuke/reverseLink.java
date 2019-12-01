package niuke;

import java.util.ArrayList;

/**
 * @author ywh
 * @date 2019/11/29 22:55
 * @description  从尾到头打印链表
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class reverseLink {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode node=new ListNode(-1);
        while(listNode!=null){
            ListNode next=listNode.next;
            listNode.next=node.next;
            node.next=listNode;
            listNode=next;
        }
        ArrayList<Integer> list=new ArrayList<>();
        ListNode head=node.next;
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        return list;
    }
}
