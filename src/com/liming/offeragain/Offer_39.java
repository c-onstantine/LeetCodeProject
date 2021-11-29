package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-27 21:03
 */
public class Offer_39 {
    public int majorityElement(int[] nums) {
        int res = 0, vote = 0;
        for (int num : nums) {
            if (vote == 0) res = num;
            vote += num == res ? 1 : -1;
        }
        return res;
    }
}
