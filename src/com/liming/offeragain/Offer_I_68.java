package com.liming.offeragain;


/**
 * @author ltf
 * @date 2021-11-23 19:55
 */
public class Offer_I_68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root != null) {
            if (p.val > root.val) {
                root = root.right;
            } else if (q.val < root.val) {
                root = root.left;
            } else break;
        }
        return root;
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
