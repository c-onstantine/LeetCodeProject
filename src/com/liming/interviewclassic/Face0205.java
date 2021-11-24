package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-04-21 21:08
 */
public class Face0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode res = new ListNode(0);
        ListNode reshead = res;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + jinwei;
            if (tmp >= 10) {
                jinwei = 1;
                l1.val = tmp % 10;
            } else {
                jinwei = 0;
                l1.val = tmp;
            }
            res.next = l1;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null) {
            while (l2 != null) {
                int tmp = l2.val + jinwei;
                if (tmp >= 10) {
                    jinwei = 1;
                    l2.val = tmp % 10;
                } else {
                    jinwei = 0;
                    l2.val = tmp;
                }
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            }
        } else if (l1 != null && l2 == null) {
            while (l1 != null) {
                int tmp = l1.val + jinwei;
                if (tmp >= 10) {
                    jinwei = 1;
                    l1.val = tmp % 10;
                } else {
                    jinwei = 0;
                    l1.val = tmp;
                }
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            }
        }

        if (jinwei != 0) {
            res.next = new ListNode(1);
        }
        return reshead.next;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
