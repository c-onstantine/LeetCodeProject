package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-08 14:19
 */
public class Offer_II_101 {
    public boolean canPartition(int[] nums) {
        int[] dp = new int[10001];

        // 相当与01背包 背包容量是数组总和一半，能凑成则说明可以分成两组， 凑不成就false
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum = sum / 2;
        //遍历物品
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum] == sum;
    }
}
