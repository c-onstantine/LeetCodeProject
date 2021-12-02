package com.liming.everyday.in202112;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-12-02 20:06
 */
public class Day2_Relative_Ranks_506 {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, (x, y) -> y - x);
        for (int i = 0; i < tmp.length; i++) {
            map.put(tmp[i], i + 1);
        }
        String[] res = new String[score.length];
        int index = 0;
        for (int num : score) {
            Integer order = map.get(num);
            if (order == 1) {
                res[index] = "Gold Medal";
            } else if (order == 2) {
                res[index] = "Silver Medal";
            } else if (order == 3) {
                res[index] = "Bronze Medal";
            } else {
                res[index] = String.valueOf(order);
            }
            index++;
        }
        return res;
    }
}
