package com.liming.tanxin;


import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-09-09 15:08
 */
public class MaximizeSumOfArrAfterKNegations_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums.length == 1) return k % 2 == 0 ? nums[0] : -nums[0];
        int index = 0;
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            if (i <= nums.length - 1 && nums[index] < 0) {
                nums[index] = -nums[index];
                if (nums[index] >= Math.abs(nums[index + 1])) index++;
                continue;
            }
            nums[index] = -nums[index];
        }

        return Arrays.stream(nums).sum();
    }
}
