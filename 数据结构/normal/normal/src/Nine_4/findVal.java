package Nine_4;

/**
 * @author ywh
 * @date 2019/9/4 17:54
 * @description 前序遍历
 */
class Node4 {
    Node4 left;
    Node4 right;
    char val;

    public Node4(char value) {
        this.val = value;
    }
}

public class findVal {
    public static Node4 find(Node4 node, char value) {
        if (node == null) {
            return null;
        }
        if (node.val == value) {
            return node;
        }
        Node4 l = find(node.left, value);
        if (l != null) {
            return l;
        }
        Node4 r = find(node.right, value);
        if (r != null) {
            return r;
        }
        return null;
    }

    public static void main(String[] args) {
        Node4 node1=new Node4('a');
        Node4 node2=new Node4('b');
        Node4 node3=new Node4('c');
        Node4 node4=new Node4('v');
        Node4 node5=new Node4('f');
        Node4 node6=new Node4('r');
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node4.right=node5;
        node4.left=node6;
        System.out.println(find(node1,'v').val);
    }
}
