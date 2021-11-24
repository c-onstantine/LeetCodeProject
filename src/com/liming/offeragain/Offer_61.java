package com.liming.offeragain;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-11-20 10:09
 * 剑指 Offer 61. 扑克牌中的顺子
 */
public class Offer_61 {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
                continue;
            }
            if (i < 3 && nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }
}
