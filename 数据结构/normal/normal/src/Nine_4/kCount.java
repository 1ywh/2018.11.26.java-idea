package Nine_4;

/**
 * @author ywh
 * @date 2019/9/4 17:39
 * @description 第k层结点的个数
 */

class Node3 {
    Node3 left;
    Node3 right;
    char val;

    public Node3(char value) {
        this.val = value;
    }
}

public class kCount {

    public static int number(Node3 node, int k) {

        if (node == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return number(node.left, k - 1) + number(node.right, k - 1);

    }

    public static void main(String[] args) {
        Node3 node1 = new Node3('a');
        Node3 node2 = new Node3('b');
        Node3 node3 = new Node3('c');
        Node3 node4 = new Node3('v');
        Node3 node5 = new Node3('f');
        Node3 node6 = new Node3('r');
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;
        node4.left = node6;
        System.out.println(number(node1, 3));
    }
}
