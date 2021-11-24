package com.liming.interviewclassic;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-06-22 20:31
 * 面试题 17.08. 马戏团人塔
 */
public class Face1708 {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int length = height.length;
        int[][] p = new int[length][2];
        for (int i = 0; i < length; i++) {
            p[i] = new int[]{height[i], weight[i]};
        }
        Arrays.sort(p, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        int[] dp = new int[length];
        int res = 0;
        for (int[] pp : p) {
            int i = Arrays.binarySearch(dp, 0, res, pp[1]);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = pp[1];
            if (i == res) {
                res++;
            }
        }
        return res;
    }
}
