package tree;

/**
 * @author ywh
 * @date 2019/11/13 20:55
 * @description   给定两个二叉树，编写一个函数来检验它们是否相同。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class isSameTree {
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
}



