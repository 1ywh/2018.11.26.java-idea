package Nine_4;

/**
 * @author ywh
 * @date 2019/9/4 17:22
 * @description 叶子节点的个数， 后序遍历
 */

class Node2 {
    Node2 left;
    Node2 right;
    char val;

    public Node2(char value) {
        this.val = value;
    }
}
public class leafCount {
    public static int number(Node2 node){
        //递归结束的条件
        if(node==null){
            return 0;
        }
        if(node.left==null&&node.right==null){
            return 1;
        }
        //先写这个
        return  number(node.left)+number(node.right);
    }
    public static void main(String[] args) {
        Node2 node1=new Node2('a');
        Node2 node2=new Node2('b');
        Node2 node3=new Node2('c');
        Node2 node4=new Node2('v');
        Node2 node5=new Node2('f');
        Node2 node6=new Node2('r');
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node4.right=node5;
        node4.left=node6;
        System.out.println(number(node1));
}
}
