package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-14 22:00
 * 剑指 Offer II 026. 重排链表
 * 思路：
 * 把链表对半分 然后后半部分反转
 * 再把两部分合并 就是重排的结果
 */
public class Offer_II_026 {
    public void reorderList(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode fast = pre, slow = pre;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode half = slow.next;
        slow.next = null;
        //反转后半部分
        ListNode r_half = reverseList(half);
        // 这里重用了 slow 和pre 两个指针  slow应该是cur节点  pre是tmp节点
        slow = head;
        while (r_half != null) {
            pre = slow.next;
            slow.next = r_half;
            slow = slow.next;
            r_half = r_half.next;
            slow.next = pre;
            slow = slow.next;
        }
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
