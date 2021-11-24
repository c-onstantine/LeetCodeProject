package com.liming.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-11-23 21:43
 * 剑指 Offer II 010. 和为 k 的子数组
 */
public class Offer_II_010 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//和为0 出现1次
        for (int num : nums) {
            sum += num;
            ret += map.getOrDefault(sum - k, 0); // 如果以前出现过这个和，那么说明从某个点到这里 和正好为k，那么 记录下和为sum-k 一共有几处，就说明有几个点可达
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
