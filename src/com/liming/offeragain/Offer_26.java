package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-13 9:20
 * 剑指 Offer 26. 树的子结构    递归先序遍历
 */
public class Offer_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return digui(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean digui(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return digui(A.left, B.left) && digui(A.right, B.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
