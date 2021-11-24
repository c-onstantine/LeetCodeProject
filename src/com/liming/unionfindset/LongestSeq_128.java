package com.liming.unionfindset;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-07-05 13:42
 */
public class LongestSeq_128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num + 1);
        }
        int ans = 0;
        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                ans = Math.max(ans, find(num + 1, map) - num + 1);
            }
        }
        return ans;
    }

    private int find(int x, Map<Integer, Integer> map) {
        return map.containsKey(x) ? find(x + 1, map) : x;
    }

}
