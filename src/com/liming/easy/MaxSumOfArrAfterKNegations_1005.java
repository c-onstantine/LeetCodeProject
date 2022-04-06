package com.liming.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author ltf
 * @date 2022-04-04 10:53
 */
public class MaxSumOfArrAfterKNegations_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums).boxed().sorted((x, y) -> {
            return Math.abs(y) - Math.abs(x);
        }).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length; i++) {
            if (k <= 0) break;
            if (nums[i] < 0 && k > 0) {
                nums[i] *= -1;
                k--;
            }
        }
        if (k % 2 == 1) nums[nums.length - 1] *= -1;
        return Arrays.stream(nums).sum();
    }
}
