package com.liming.tanxin;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-01-21 10:42
 */
public class Arrows_Burst_Balloons452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (int[] a, int[] b) -> {
            if (a[1] < b[1])
                return -1;
            else if (a[1] > b[1])
                return 1;
            else return 0;
        });

        int count = 1;
        int end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
