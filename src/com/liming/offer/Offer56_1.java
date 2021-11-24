package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-29 19:07
 */
public class Offer56_1 {
    public int[] singleNumbers(int[] nums) {
        if (nums == null) return new int[0];
        int index = 0;
        for (int num : nums) {
            index ^= num;
        }
        if (index == 0) return new int[0];
        int rindex = 0;
        while ((index & 1) == 0) {
            index >>= 1;
            rindex++;
        }
        int[] res = new int[2];
        for (int num : nums) {
            if (isOne(num, rindex)) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    private boolean isOne(int num, int rindx) {
        num >>= rindx;
        return (num & 1) == 1 ? true : false;
    }
}
