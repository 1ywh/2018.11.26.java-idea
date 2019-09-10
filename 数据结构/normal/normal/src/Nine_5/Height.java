package Nine_5;

/**
 * @author ywh
 * @date 2019/9/5 17:19
 * @description 二叉树的高度
 */
public class Height {
    static class Node {
        Node left;
        Node right;
        char val;

        Node(char value) {
            this.val = value;
        }
    }

    public static int HeightCount(Node root) {
        if (root == null) {
            return 0;
        } else {
            int left = HeightCount(root.left);
            int right = HeightCount(root.right);
            return left > right ? left + 1 : right + 1;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node('a');
        Node node2 = new Node('b');
        Node node3 = new Node('c');
        Node node4 = new Node('v');
        Node node5 = new Node('f');
        Node node6 = new Node('r');
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;
        node4.left = node6;
        System.out.println(HeightCount(node1));
    }
}
