package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-19 15:18
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        int cur = 0;
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) cur = num;
            vote += num == cur ? 1 : -1;
        }
        return cur;
    }
}
