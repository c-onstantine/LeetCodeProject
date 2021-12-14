package com.liming.mietun;

/**
 * @author ltf
 * @date 2021-11-04 21:50
 */
public class PalindromeLinkedList_234 {
    // 垃圾彩笔写法
    //public boolean isPalindrome(ListNode head) {
    //    StringBuilder sb = new StringBuilder();
    //    while (head != null) {
    //        sb.append(head.val);
    //        head = head.next;
    //    }
    //    return sb.toString().equals(sb.reverse().toString());
    //}


    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode pre = null, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        // 奇数个链表节点 slow再往前移动一位
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
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
