package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-05 19:57
 */
public class Offer_II_092 {
    public int minFlipsMonoIncr(String s) {
        //dp[i][0]表示前i个元素，最后一个元素为0的最小翻转次数；
        //dp[i][1]表示前i个元素，最后一个元素为1的最小翻转次数
        int[][] dp = new int[s.length()][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '1' ? 0 : 1);
        }
        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
    }
}
