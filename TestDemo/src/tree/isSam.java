package tree;

/**
 * @author ywh
 * @date 2019/11/18 19:26
 * @description 力扣572：一棵树的子树
 */
public class isSam {
    //相同二叉树
    public boolean isSameTree(TreeNode p, TreeNode q) {

        //如果俩个树都为空的话
        if (p == null && q == null)
            return true;
        //俩个树由一个为空
        if (p == null || q == null)
            return false;
        //俩个树都不为空，如果值不相等返回false
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubTree(TreeNode s, TreeNode t) {
        //有一个为空
        if (s == null || t == null) {
            return false;
        }
        if (s == null && t == null) {
            return true;
        }
        if (isSameTree(s, t)) {
            return true;
        } else if (isSameTree(s.left, t)) {
            return true;
        } else if (isSameTree(s.right, t)) {
            return true;
        } else {
            return false;
        }
    }
}
