package com.liming.offer;


import java.util.HashMap;

/**
 * @author ltf
 * @date 2021-02-21 11:05
 */
public class Offer07 {
    private HashMap<Integer, Integer> inmap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inmap = new HashMap<>();
        int in = inorder.length;
        for (int i = 0; i < in; i++) {
            inmap.put(inorder[i], i);
        }
        return btree(preorder, 0, in - 1, inorder, 0, in - 1);
    }

    private TreeNode btree(int[] preorder, int pstart, int pend, int[] inorder, int instart, int inend) {
        if (pstart > pend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int rindex = inmap.get(preorder[pstart]);
        int red = rindex - instart;
        root.left = btree(preorder, pstart + 1, pstart + red, inorder, instart, rindex - 1);
        root.right = btree(preorder, pstart + red + 1, pend, inorder, rindex + 1, inend);
        return root;
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
