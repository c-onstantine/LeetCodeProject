package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-30 19:10
 */
public class Offer56_2 {
    public int singleNumber(int[] nums) {
        int[] bitsum = new int[32];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int bitmask = 1;
            for (int j = 31; j >= 0; j--) {
                int b = nums[i] & bitmask;
                if (b != 0) bitsum[j] += 1;
                bitmask <<= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += bitsum[i] % 3;
        }
        return result;
    }
}
