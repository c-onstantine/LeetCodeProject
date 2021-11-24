package com.liming.offer;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-02-18 17:32
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        digui(head, res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void digui(ListNode head, List<Integer> res) {
        ListNode tmp = head;
        if (tmp != null) {
            digui(tmp.next, res);
            res.add(tmp.val);
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
