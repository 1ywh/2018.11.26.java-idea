package Eight_15;

/**
 * @author ywh
 * @date  2019/9/2 17:01
 * @description 反转链表
 */
public class reverse {
    static class Node {
        public int value;
        public Node next = null;

        Node(int val) {
            this.value = val;
        }
    }

    //    public static Node rev(Node head) {
//        if (head == null) {
//            return null;
//        }
//        Node pre = head.next;
//        head.next=null;
//        while (pre != null) {
//            Node cur = pre;
//            pre = cur.next;
//            cur.next = head;
//            head = cur;
//        }
//        return head;
//    }
    public static Node reve(Node head) {
        Node newNode = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = newNode;
            newNode = cur;
            cur = next;
        }
        return newNode;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Node c = reverse.reve(n1);
        for (; c != null; c = c.next) {
            System.out.println(c.value);
        }

    }
}
