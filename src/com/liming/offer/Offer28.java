package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-10 10:41
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        return digui(root,root);
    }

    private boolean digui(TreeNode roo1, TreeNode root2) {
        if (roo1 == null && root2 == null)
            return true;
        if (roo1 == null || root2 == null)
            return false;
        if (roo1.val != root2.val)
            return false;
        return digui(roo1.left, root2.right) && digui(roo1.right, root2.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
