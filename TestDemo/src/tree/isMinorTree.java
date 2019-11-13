package tree;

/**
 * @author ywh
 * @date 2019/11/13 21:12
 * @description   对称二叉树
 */
public class isMinorTree {
    public boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }
        return isSubTree(s.left, t.right) && isSubTree(s.right, t.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSubTree(root.left,root.right);
    }
}
