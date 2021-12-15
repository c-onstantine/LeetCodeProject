package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-15 10:05
 * 剑指 Offer II 027. 回文链表
 */
public class Offer_II_027 {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //复用 fast 和slow  让fast指向后半部分头  slow 指向前半部分头
        fast = reverseList(slow.next);
        slow = head;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
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
