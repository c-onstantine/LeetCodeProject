package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-08 14:27
 * left-right = target  left + right = sum  而 targe和 sum都是固定的  left-(sum-left) = target 得到 left = (target+sum)/2;
 * 转化为01背包 也就是要装满容量为left的组合
 */
public class Offer_II_102 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 除不尽 就凑不出left
        if ((target + sum) % 2 == 1) return 0;
        if (Math.abs(target) > sum) return 0; // 凑不出来
        int left = (target + sum) / 2;
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];
    }
}
