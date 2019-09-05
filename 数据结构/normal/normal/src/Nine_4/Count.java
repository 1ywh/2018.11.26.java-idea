package Nine_4;

/**
 * @author ywh
 * @date 2019/9/4 17:05
 * @description 结点的个数
 */
class Node1 {
    Node1 left;
    Node1 right;
    char val;

    public Node1(char value) {
        this.val = value;
    }
}

public class Count {
   // private static int count = 0;

    private static int number(Node1 node) {
        if (node == null) {
            return 0;
        }
//        int left = number(node.left);
//        int right = number(node.right);
//        count = left + right + 1;
//        return count;
        //后序遍历
        return  number(node.left)+number(node.right)+1;
    }

    public static void main(String[] args) {
        Node1 node1=new Node1('a');
        Node1 node2=new Node1('b');
        Node1 node3=new Node1('c');
        Node1 node4=new Node1('v');
        Node1 node5=new Node1('f');
        Node1 node6=new Node1('r');
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node4.right=node5;
        node4.left=node6;
        System.out.println(number(node1));
    }

}
