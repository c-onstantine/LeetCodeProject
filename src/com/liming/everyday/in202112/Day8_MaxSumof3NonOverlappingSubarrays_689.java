package com.liming.everyday.in202112;

/**
 * @author ltf
 * @date 2021-12-08 17:37
 * 689. 三个无重叠子数组的最大和
 */
public class Day8_MaxSumof3NonOverlappingSubarrays_689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        reverse(nums);
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        long[][] dp = new long[n + 5][4];
        for (int i = k; i <= n; i++) {
            for (int j = 1; j < 4; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - k][j - 1] + sum[i] - sum[i - k]);
            }
        }
        int[] res = new int[3];
        int i = n, j = 3, index = 0;
        while (j > 0) {
            if (dp[i - 1][j] > dp[i - k][j - 1] + sum[i] - sum[i - k]) {// 当不考虑num[i]时 获得的结果更大时
                i--;
            } else {
                res[index++] = n - i;
                i -= k;
                j--;
            }
        }
        return res;
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }
}
