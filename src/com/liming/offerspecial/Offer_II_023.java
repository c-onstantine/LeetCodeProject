package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-14 21:06
 * 剑指 Offer II 023. 两个链表的第一个重合节点
 */
public class Offer_II_023 {
    // 没有交点 为null时 也会相等 跳出循环 返回null
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
