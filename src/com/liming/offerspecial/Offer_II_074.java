package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ltf
 * @date 2021-12-30 18:53
 */
public class Offer_II_074 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> tmp = new ArrayList<>();
        int len = intervals.length;
        int idx = 0;
        while (idx < len) {
            int start = intervals[idx][0], end = intervals[idx][1];
            while (idx < len - 1 && end >= intervals[idx + 1][0]) {
                end = Math.max(end, intervals[idx + 1][1]);
                idx++;
            }
            tmp.add(new int[]{start, end});
            idx++;
        }
        return tmp.toArray(new int[tmp.size()][]);
    }
}
