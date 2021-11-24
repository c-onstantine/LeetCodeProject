package com.liming.link;

/**
 * @author ltf
 * @date 2021-01-11 15:30
 */

public class KthLink22Offer {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int one=0;
        ListNode tmp =head;
        while(tmp!=null){
            one++;
            tmp=tmp.next;
        }
        int two=one-k;
        while (two>0){
            two--;
            head=head.next;
        }
        return head;
    }


}
