package com.liming.mid;

import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-04-06 21:26
 */
public class AddTwoNumbersII_445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strl1 = sc.nextLine().split(",");
        String[] strl2 = sc.nextLine().split(",");
        ListNode l1 = new ListNode(Integer.valueOf(strl1[0]));
        ListNode l2 = new ListNode(Integer.valueOf(strl2[0]));
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        for (int i = 1; i < strl1.length; i++) {
            tmp1.next = new ListNode(Integer.valueOf(strl1[i]));
            tmp1 = tmp1.next;
        }
        for (int i = 1; i < strl2.length; i++) {
            tmp2.next = new ListNode(Integer.valueOf(strl2[i]));
            tmp2 = tmp2.next;
        }
        new AddTwoNumbersII_445().addTwoNumbers(l1,l2);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode res = new ListNode();
        ListNode dummy = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int tmp = x + y + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            dummy.next = new ListNode(tmp);
            dummy = dummy.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return res.next;
    }

    private ListNode reverseList(ListNode l) {
        ListNode pre = null, cur = l, tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private static class ListNode {
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
