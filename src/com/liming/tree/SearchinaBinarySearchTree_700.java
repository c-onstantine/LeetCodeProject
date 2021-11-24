package com.liming.tree;

/**
 * @author ltf
 * @date 2021-09-01 21:09
 */
public class SearchinaBinarySearchTree_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val) root = root.left;
            else if (root.val < val) root = root.right;
            else return root;
        }
        return null;
    }
}
