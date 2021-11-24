package com.liming.tree;

/**
 * @author ltf
 * @date 2021-08-30 21:20
 */
public class ConstructBinTreefromInandPostrTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return buildT(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildT(int[] inorder, int inleft, int inright, int[] postorder, int poleft, int poright) {
        if (inright - inleft == 0) return null;
        int val = postorder[poright - 1];
        TreeNode root = new TreeNode(val);
        if (poright - poleft == 1) return root;
        int index;
        for (index = inleft; index < inright; index++) {
            if (inorder[index] == val) break;
        }
        int ninright = index;
        int nleft1 = index + 1;
        int nporight = poleft + ninright - inleft;
        int npoleft1 = poleft + ninright - inleft;
        root.left = buildT(inorder, inleft, ninright, postorder, poleft, nporight);
        root.right = buildT(inorder, nleft1, inright, postorder, npoleft1, poright - 1);
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
