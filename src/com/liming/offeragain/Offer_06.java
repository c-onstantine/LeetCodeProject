package com.liming.offeragain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-11-06 21:17
 */
public class Offer_06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = recursion(head, new ArrayList<>());
        if (res == null) return new int[0];
        int[] r = new int[res.size()];
        int index = 0;
        for (Integer re : res) {
            r[index++] = re;
        }
        return r;
    }

    private List<Integer> recursion(ListNode head, List<Integer> res) {
        if (head == null) return null;
        recursion(head.next, res);
        res.add(head.val);
        return res;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
