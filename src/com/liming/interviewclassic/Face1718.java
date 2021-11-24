package com.liming.interviewclassic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-06-28 19:34
 */
public class Face1718 {
    public int[] shortestSeq(int[] big, int[] small) {
        int start = 0, end = big.length;
        int count = small.length;
        if (count > end) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : small) {
            map.put(i, -1);
        }
        for (int i = 0; i < big.length; i++) {
            if (map.containsKey(big[i])) {
                if (map.get(big[i]) == -1) {
                    count--;
                }
                map.put(big[i], i);
            }
            if (count <= 0) {
                int min = Integer.MAX_VALUE;
                for (Integer value : map.values()) {
                    if (min > value) {
                        min = value;
                    }
                }
                if (end - start > i - min) {
                    start = min;
                    end = i;
                }
            }
        }
        if (count > 0) {
            return new int[0];
        }
        return new int[]{start, end};
    }
}
