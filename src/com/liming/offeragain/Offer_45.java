package com.liming.offeragain;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-11-20 9:53
 * 剑指 Offer 45. 把数组排成最小的数
 */
public class Offer_45 {
    public String minNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (String str : s) {
            sb.append(str);
        }
        return sb.toString();
    }
}
