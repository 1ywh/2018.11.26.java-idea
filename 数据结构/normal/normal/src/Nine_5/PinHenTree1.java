package Nine_5;

/**
 * @author ywh
 * @date 2019/11/18 21:05
 * @description 平衡二叉树
 */
public class PinHenTree1 {
    public int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = count(node.left);
        int right = count(node.right);
        return left > right ? left + 1 : right + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(count(root.left) - count(root.right)) < 2 &&
                    isBalanced(root.left) &&
                    isBalanced(root.right) ? true : false;
        }
    }
    //方法2
//    public boolean isBalanced(TreeNode root) {
//        return dep(root)!=-1;
//    }
//    public int dep(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        int left=dep(root.left);
//        if(left==-1) return -1;
//        int right=dep(root.right);
//        if(right==-1) return -1;
//        return Math.abs(left-right)<2?Math.max(right,left)+1:-1;
//    }
}
