package com.liming.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2022-01-29 13:15
 * 1. 两数之和
 */
public class Hot_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
