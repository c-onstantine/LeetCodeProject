package com.liming.hot100;

/**
 * @author ltf
 * @date 2022-01-29 16:47
 */
public class Hot_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, tmp = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            tmp = x + y + carry;
            carry = tmp / 10;
            tmp %= 10;
            cur.next = new ListNode(tmp);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
