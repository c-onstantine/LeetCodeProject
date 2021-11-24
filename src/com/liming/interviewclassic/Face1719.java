package com.liming.interviewclassic;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-06-29 20:00
 */
public class Face1719 {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sum = Arrays.stream(nums).sum();
        int twoSum = n * (1 + n) / 2 - sum;
        int lim = twoSum / 2;
        sum = 0;
        for (int num : nums) {
            if (num <= lim) sum += num;
        }
        int one = lim * (1 + lim) / 2 - sum;
        return new int[]{one, twoSum - one};
    }
}
