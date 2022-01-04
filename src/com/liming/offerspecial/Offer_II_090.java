package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-04 21:02
 */
public class Offer_II_090 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int r1 = baseRob(nums, 0, nums.length - 2);// 不考虑尾巴 考虑头部
        int r2 = baseRob(nums, 1, nums.length - 1);// 不考虑头部 考虑尾巴
        return Math.max(r1, r2);
    }

    private int baseRob(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int dp0 = nums[start];
        int dp1 = Math.max(nums[start], nums[start + 1]);
        int tmp = 0;
        for (int i = start + 2; i <= end; i++) {
            tmp = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = tmp;
        }
        return dp1;
    }
}
