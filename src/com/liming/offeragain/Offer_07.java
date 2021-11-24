package com.liming.offeragain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-11-24 9:30
 * 剑指 Offer 07. 重建二叉树
 */
public class Offer_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int pbegin, int pend, int[] inorder, int ibegin, int iend, Map<Integer, Integer> map) {
        if (pbegin > pend || ibegin > iend) return null;
        int rootVal = preorder[pbegin];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.left = build(preorder, pbegin + 1, pbegin + index - ibegin, inorder, ibegin, index - 1, map);
        root.right = build(preorder, pbegin + index - ibegin + 1, pend, inorder, index + 1, iend, map);
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
