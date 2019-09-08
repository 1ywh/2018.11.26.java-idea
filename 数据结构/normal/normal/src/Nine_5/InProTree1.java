package Nine_5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ywh
 * @date 2019/9/8 13:44
 * @description 递归前序遍历，返回值不一样，主要是找到递归的结束条件
 */
public class InProTree1 {
    static class Node {
        char val;
        Node left;
        Node right;

        Node(char val) {
            this.val = val;
        }
    }

//    static List<Character> list = new ArrayList<>();
//    //1.返回的是一个list
//        public static List<Character> test(Node node) {
//        if (node == null) {
//            return list;
//        }
//        list.add(node.val);
//        test(node.left);
//        test(node.right);
//        return list;
//    }

    //2.返回的是void
    public static void test(Node node) {
        if (node == null) {
            return ;
        }
        System.out.println(node.val);
        test(node.left);
        test(node.right);
    }

    public static void main(String[] args) {
        Node node1 = new Node('a');
        Node node2 = new Node('b');
        Node node3 = new Node('c');
        Node node4 = new Node('d');
        Node node5 = new Node('e');
        Node node6 = new Node('f');
        Node node7 = new Node('g');
        Node node8 = new Node('h');
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node8;
        node3.left = node6;
        node3.right = node7;
//        List<Character> list = test(node1);
//        for (Character a : list) {
//            System.out.println(a);
//        }

        test(node1);
    }
}
