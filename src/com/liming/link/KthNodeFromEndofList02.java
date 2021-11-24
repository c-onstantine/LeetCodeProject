package com.liming.link;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-01-05 19:03
 */


 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class KthNodeFromEndofList02 {
    public int kthToLast(ListNode head, int k) {
        List<Integer> temp=new ArrayList<>();
        while (head!=null){
            temp.add(head.val);
            head=head.next;
        }
        return temp.get(temp.size()-k);
    }
}
