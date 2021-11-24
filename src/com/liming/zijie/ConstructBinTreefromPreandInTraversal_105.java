package com.liming.zijie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-10-16 10:22
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class ConstructBinTreefromPreandInTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend, Map<Integer, Integer> map) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int midindex = map.get(preorder[pstart]);
        int len1 = midindex - istart;
        int len2 = iend - midindex;
        root.left = build(preorder, pstart + 1, pstart + len1, inorder, istart, midindex, map);
        root.right = build(preorder, pstart + len1 + 1, pend, inorder, midindex + 1, iend, map);
        return root;
    }

    public class TreeNode {
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
