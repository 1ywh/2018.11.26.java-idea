package com.bittech.tree;

/**
 * 找和val相等的root
 * Author:ywh
 * Date:2019/04/18
 */
public class FindTree {
    private static class Node {
        char val;
        Node left;
        Node right;

        Node(char x) {
            val = x;
        }
    }
        public  Node Find(Node root,char val){
           //1.空树的判断
            if(root==null){
                return null;
            }
            //2.
            else if(root.val==val){
                return root;
            }else if((Find(root.left,val))!=null) {
                return (Find(root.left,val));
            }
            else if((Find(root.right,val))!=null){
                    return (Find(root.right,val));
            }
            return null;
    }

    public static void main(String[] args) {
        Node root1 = new Node('a');
        Node root2 = new Node('b');
        Node root3 = new Node('c');
        Node root4 = new Node('d');
        Node root5 = new Node('e');
        Node root6 = new Node('f');
        Node root7 = new Node('g');
        Node root8 = new Node('h');
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root5.right = root8;
        root3.left = root6;
        root3.right = root7;
        System.out.println(new FindTree().Find(root1,'f').val);

    }
}
