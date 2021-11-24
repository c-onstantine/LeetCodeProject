package com.liming.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-27 14:23
 */
public class BinaryTreePaths_257 {
    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        back(root, new String());
        return res;
    }

    private void back(TreeNode root, String sb) {
        sb += root.val;
        if (root.left == null && root.right == null) {
            res.add(sb);
            return;
        }
        if (root.left != null) {
            back(root.left, sb + "->");
        }
        if (root.right != null) {
            back(root.right, sb + "->");
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
