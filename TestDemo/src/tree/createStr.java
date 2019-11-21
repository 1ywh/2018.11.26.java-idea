package tree;

/**
 * @author ywh
 * @date 2019/11/21 16:04
 * @description 二叉树创建字符串
 */

public class createStr {

    StringBuilder sb = new StringBuilder();

    public void treestr(TreeNode root) {
        //递归的出口
        if (root == null) {
            return ;
        }
        //在最后会去掉
        sb.append("(");
        sb.append(root.val);
        //先访问左子树
        treestr(root.left);
        if (root.left == null && root.right != null) {
            sb.append("()");
        }
        //访问右子树
        treestr(root.right);
//        if (root.right == null && root.left != null) {
//            sb.append(" ");
//        }
        //全部访问完
        sb.append(")");
    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        treestr(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}