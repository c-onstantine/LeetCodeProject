package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-13 10:15
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class Offer_42 {
    //public int maxSubArray(int[] nums) {
    //    int res = nums[0];
    //    for (int i = 1; i < nums.length; i++) {
    //        nums[i] += Math.max(nums[i - 1], 0);
    //        res = Math.max(res, nums[i]);
    //    }
    //    return res;
    //}

    public int maxSubArray(int[] nums) {
        int res = nums[0], tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmp < 0) tmp = 0;
            tmp += nums[i];
            res = Math.max(tmp, res);
        }
        return res;
    }
}
