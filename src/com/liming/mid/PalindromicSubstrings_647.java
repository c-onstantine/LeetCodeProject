package com.liming.mid;

/**
 * @author ltf
 * @date 2021-08-17 11:23
 * 647. 回文子串  双指针法  也可以用动态规划 dp  但是空间复杂度较高
 */
public class PalindromicSubstrings_647 {
    //public int countSubstrings(String s) {
    //    int res = 0;
    //    for (int i = 0; i < s.length(); i++) {
    //        res += huiwen(s, i, i);
    //        res += huiwen(s, i, i + 1);
    //    }
    //    return res;
    //}
    //
    //private int huiwen(String s, int i, int j) {
    //    int res = 0;
    //    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
    //        i--;
    //        j++;
    //        res++;
    //    }
    //    return res;
    //}

    //    dp 方法
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }
}
