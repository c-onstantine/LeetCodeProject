package com.liming.tree;

/**
 * @author ltf
 * @date 2021-09-06 19:20
 * 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestorofBSTree_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else return root;
        }
        return null;
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
