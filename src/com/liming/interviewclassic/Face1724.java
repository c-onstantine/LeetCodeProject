package com.liming.interviewclassic;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-06-30 20:15
 */
public class Face1724 {
    public int[] getMaxMatrix(int[][] matrix) {
        int[] res = new int[4];
        int n = matrix.length;
        int m = matrix[0].length;
        int dp;
        int max = Integer.MIN_VALUE;
        int[] tmp = new int[m];
        int r1 = 0, c1 = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(tmp, 0); //每次扩展都要清零
            for (int j = i; j < n; j++) {
                dp = 0;
                for (int k = 0; k < m; k++) {
                    tmp[k] += matrix[j][k];
                    if (dp > 0) {
                        dp += tmp[k];
                    } else {
                        dp = tmp[k];
                        r1 = i;
                        c1 = k;
                    }
                    if (max < dp) {
                        max = dp;
                        res[0] = r1;
                        res[1] = c1;
                        res[2] = j;
                        res[3] = k;
                    }
                }
            }
        }
        return res;
    }



}
