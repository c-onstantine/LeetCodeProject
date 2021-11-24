package com.liming.interviewclassic;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-05-12 20:49
 * 布尔运算 记忆化搜索
 */
public class Face0814 {
    private char[] arr;
    private int[][][] dp;

    public int countEval(String s, int result) {
        arr = s.toCharArray();
        int len = s.length();
        dp = new int[len][len][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return memSearch(0, len - 1, result);
    }

    private int memSearch(int start, int end, int res) {
        if (start == end) {
            return arr[start] - '0' == res ? 1 : 0;
        }
        if (dp[start][end][res] != -1) {
            return dp[start][end][res];
        }
        int ans = 0;
        for (int i = start; i < end; i += 2) {
            char op = arr[i + 1];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (processop(j, k, op) == res) {
                        ans += memSearch(start, i, j) * memSearch(i + 2, end, k);
                    }
                }
            }
        }
        dp[start][end][res] = ans;

        return ans;
    }

    private int processop(int v1, int v2, char op) {
        switch (op) {
            case '&':
                return v1 & v2;
            case '|':
                return v1 | v2;
            case '^':
                return v1 ^ v2;
        }
        return v1 & v2;
    }

}
