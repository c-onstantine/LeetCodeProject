package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-14 21:40
 */
public class Offer_II_025 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //反转两个链表
        ListNode rl1 = reverseList(l1);
        ListNode rl2 = reverseList(l2);
        int sum = 0, jinwei = 0;
        ListNode ret = new ListNode();
        ListNode cur = ret;
        while (rl1 != null || rl2 != null || jinwei != 0) {
            sum = 0;
            if (rl1 != null) {
                sum += rl1.val;
                rl1 = rl1.next;
            }
            if (rl2 != null) {
                sum += rl2.val;
                rl2 = rl2.next;
            }
            sum += jinwei;
            jinwei = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        return reverseList(ret.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
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
