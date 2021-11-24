package com.liming.dp;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-08-07 17:50
 * 62. 不同路径
 */
public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        int[] path = new int[n];
        Arrays.fill(path, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[j] += path[j - 1];
            }
        }
        return path[n - 1];
    }
}
