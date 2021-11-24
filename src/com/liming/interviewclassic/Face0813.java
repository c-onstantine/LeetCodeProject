package com.liming.interviewclassic;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-05-12 20:14
 */
public class Face0813 {
    public int pileBox(int[][] box) {
        if (box == null || box.length == 0) {
            return 0;
        }
        Arrays.sort(box, (a, b) -> Integer.compare(a[2], b[2]));
        int ans = 1;
        int[] dp = new int[box.length];
        for (int i = 0; i < box.length; i++) {
            int max = box[i][2];
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    max = Math.max(dp[j] + box[i][2], max);
                }
            }
            dp[i] = max;
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
