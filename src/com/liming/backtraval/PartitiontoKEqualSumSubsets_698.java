package com.liming.backtraval;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-08-12 15:33
 * 698. 划分为k个相等的子集
 */
public class PartitiontoKEqualSumSubsets_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        if (sum % k != 0 || max > (sum / k)) return false;
        boolean[] vis = new boolean[nums.length];
        return back(nums, k, sum / k, 0, 0, vis);
    }

    private boolean back(int[] nums, int k, int target, int cur, int start, boolean[] vis) {
        if (k == 0) return true;
        if (cur == target) {
            return back(nums, k - 1, target, 0, 0, vis);
        }
        for (int i = start; i < nums.length; i++) {
            if (!vis[i] && cur + nums[i] <= target) {
                vis[i] = true;
                if (back(nums, k, target, cur + nums[i], i + 1, vis)) return true;
                vis[i] = false;
            }
        }
        return false;
    }
}
