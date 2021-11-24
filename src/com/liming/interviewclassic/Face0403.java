package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ltf
 * @date 2021-04-27 11:34
 */
public class Face0403 {
    private Queue<TreeNode> queue = new LinkedList<>();

    public ListNode[] listOfDepth(TreeNode tree) {
        ArrayList<ListNode> res = new ArrayList<>();
        if (tree == null) return null;
        queue.offer(tree);
        while (!queue.isEmpty()) {
            ListNode head = null;
            ListNode iter = null;
            int cur = queue.size();
            for (int i = 0; i < cur; i++) {
                TreeNode peek = queue.peek();
                ListNode newnode = new ListNode(peek.val);
                queue.poll();
                if (head == null) {
                    head = newnode;
                } else {
                    iter.next = newnode;
                }
                iter = newnode;
                if (peek.left != null) {
                    queue.offer(peek.left);
                }
                if (peek.right != null) {
                    queue.offer(peek.right);
                }
            }
            res.add(head);

        }
        ListNode[] realres = new ListNode[res.size()];
        return res.toArray(realres);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
