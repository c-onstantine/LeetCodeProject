package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-05 19:52
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean res = false;
        if (A != null && B != null) {
            if (A.val == B.val) {
                res = tree1HasTree2(A, B);
            }
            if (!res) {
                res = isSubStructure(A.left, B);
            }
            if (!res) {
                res = isSubStructure(A.right, B);
            }
        }
        return res;
    }

    private boolean tree1HasTree2(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (!(A.val == B.val)) return false;

        return tree1HasTree2(A.left, B.left) && tree1HasTree2(A.right, B.right);
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
