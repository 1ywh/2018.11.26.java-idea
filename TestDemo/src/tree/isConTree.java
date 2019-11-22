package tree;

/**
 * @author ywh
 * @date 2019/11/21 17:19
 * @description   找到俩个结点的最近公共祖先
 */
public class isConTree {
    //建助辅助函数，再root中递归查找p和q
    //找到返回1,没找到返回0
    //在左子树、右子树、对比根节点，如果三个位置中有俩个位置找到了就返回找到了
    TreeNode node = null;

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)  {
            return false;
        }
        //左子树寻找q或者p
        int left = find(root.left, p, q) ? 1 : 0;
        //右子树寻找q或者p
        int right = find(root.right, p, q) ? 1 : 0;
        //
        int mid = (p == root || q == root) ? 1 : 0;
        //最近的出现俩次
        if (mid + left + right >= 2) {
            node = root;
        }
        //大于0找到
        return mid + left + right > 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        find(root, p, q);
        return node;
    }
}
