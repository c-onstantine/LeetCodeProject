package com.liming.offerspecial;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-12-09 19:42
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * map存的是 sum第一次出现的位置，如果后面还出现 则说明两个sum之前的数字 和为0  也就是 0 和1 的个数相同
 */
public class Offer_II_011 {
    public int findMaxLength(int[] nums) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
