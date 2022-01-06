package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-06 10:32
 */
public class Offer_II_094 {
    public int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        //先用双指针法 确定所有回文子串
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i, s.length(), isPalindrome);
            extend(s, i, i + 1, s.length(), isPalindrome);
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;  //0次分割
            } else {
                dp[i] = i;  // 初始为最大切割
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }

                }
            }
        }
        return dp[s.length() - 1];
    }

    private void extend(String s, int left, int right, int n, boolean[][] isPalindrome) {
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            isPalindrome[left][right] = true;
            left--;
            right++;
        }
    }
}
