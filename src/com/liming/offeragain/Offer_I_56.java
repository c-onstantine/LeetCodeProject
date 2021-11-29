package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-27 13:34
 */
public class Offer_I_56 {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int mark = 1;
        while ((res & mark) == 0) {
            mark <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mark) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
