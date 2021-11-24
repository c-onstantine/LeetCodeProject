package com.liming.ali;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-11-10 19:23
 */
public class ConstructBTreefromInorderandPostorderTraversal_106 {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (iend < istart || pend < pstart) return null;
        int rootVal = postorder[pend];
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, istart, rootIndex - 1, postorder, pstart, pstart + rootIndex - istart - 1);
        root.right = buildTree(inorder, rootIndex + 1, iend, postorder, pstart + rootIndex - istart, pend - 1);
        return root;
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
