package com.liming.offer;

/**
 * @author ltf
 * @date 2021-04-12 20:13
 */
public class Offer68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if (root.val < p.val && root.val < q.val){
                root = root.right;
            }else if (root.val > p.val && root.val > q.val){
                root = root.left;
            }else {
                break;
            }
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
