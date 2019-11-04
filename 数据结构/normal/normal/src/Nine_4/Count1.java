package Nine_4;

/**
 * @author ywh
 * @date 2019/11/4 9:44
 * @description   结点的个数
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    char val;

    public TreeNode(char value) {
        this.val = value;
    }
}

public class Count1 {
    private static int size;
    public static void count(TreeNode node){
        if(node==null){
            return ;
        }
        size++;
        count(node.left);
        count(node.right);
    }
    public static void main(String[] args) {
        TreeNode node1=new TreeNode('a');
        TreeNode node2=new TreeNode('b');
        TreeNode node3=new TreeNode('c');
        TreeNode node4=new TreeNode('v');
        TreeNode node5=new TreeNode('f');
        TreeNode node6=new TreeNode('r');
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node4.right=node5;
        node4.left=node6;
        count(node1);
        System.out.println(size);
    }
}
