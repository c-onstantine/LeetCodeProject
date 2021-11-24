package com.liming.tree;

import java.util.HashMap;

/**
 * @author ltf
 * @date 2021-02-17 12:17
 */
public class ConstructBTree105 {
    private HashMap<Integer, Integer> inmap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inlen = inorder.length;
        int prelen = preorder.length;
        for (int i = 0; i < inlen; i++) {
            inmap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, prelen - 1, inorder, 0, inlen - 1);
    }

    private TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int instart, int inend) {
        if (pstart > pend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int rindex = inmap.get(root.val);
        int insum = rindex - instart;
        root.left = buildTree(preorder, pstart + 1, pstart + insum, inorder, instart, rindex - 1);
        root.right = buildTree(preorder, pstart + insum + 1, pend, inorder, rindex + 1, inend);
        return root;
    }

    static class TreeNode {
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
