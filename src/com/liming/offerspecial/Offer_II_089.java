package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-04 20:49
 */
public class Offer_II_089 {
    //public int rob(int[] nums) {
    //
    //    int m = nums.length;
    //    if (m == 1) return nums[0];
    //    int[] dp = new int[m];
    //    dp[0] = nums[0];
    //    dp[1] = Math.max(nums[0], nums[1]);
    //    for (int i = 2; i < m; i++) {
    //        dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    //    }
    //    return dp[m - 1];
    //}
// 压缩空间
    public int rob(int[] nums) {

        int m = nums.length;
        if (m == 1) return nums[0];
        int dp1 = nums[0];
        int dp2 = Math.max(nums[0], nums[1]);
        int tmp = 0;
        for (int i = 2; i < m; i++) {
            tmp = Math.max(dp1 + nums[i], dp2);
            dp1 = dp2;
            dp2 = tmp;
        }
        return dp2;
    }

}
