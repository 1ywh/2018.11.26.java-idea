package niuke;

import java.util.ArrayList;

/**
 * @author ywh
 * @date 2019/12/8 9:48
 * @description    二叉树的全部路径
 */


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    static int sum = 0;

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        sum = sum + root.val;
        list.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            result.add(list);
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        sum = sum - root.val;
        return result;
    }

    public static void main(String[] args) {
        TreeNode roo1 = new TreeNode(10);
        TreeNode roo2 = new TreeNode(5);
        TreeNode roo3 = new TreeNode(12);
        TreeNode roo4 = new TreeNode(4);
        TreeNode roo5 = new TreeNode(7);
        roo1.left = roo2;
        roo1.right = roo3;
        roo2.left = roo4;
        roo2.right = roo5;
        FindPath(roo1, 22);
    }
}