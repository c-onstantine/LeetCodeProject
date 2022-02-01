package com.liming.hot100;

/**
 * @author ltf
 * @date 2022-02-01 14:38
 * 5. 最长回文子串
 */
public class Hot_5 {
    //// 中心扩散解法
    //public String longestPalindrome(String s) {
    //    int length = s.length();
    //    if (length < 2) return s;
    //    int[] res = new int[2];
    //    for (int i = 0; i < length - 1; i++) {
    //        int[] t1 = spread(s, i, i);//重合下标 奇数回文
    //        int[] t2 = spread(s, i, i + 1);//偶数回文
    //        int[] max = t1[1] > t2[1] ? t1 : t2;
    //        if (res[1] < max[1]) {
    //            res = max;
    //        }
    //    }
    //    return s.substring(res[0], res[0] + res[1]);
    //}
    //
    //private int[] spread(String str, int left, int right) {
    //    int length = str.length();
    //    while (left >= 0 && right < length) {
    //        if (str.charAt(left) == str.charAt(right)) {
    //            left--;
    //            right++;
    //        } else {
    //            break;
    //        }
    //    }
    //    return new int[]{left + 1, right - left - 1};
    //}

    //    动态规划解法
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        if (s.length() < 2) return s;
        int max = 1;
        int begin = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                } else {
                    dp[j][i] = false;
                }
                if (dp[j][i] && i - j + 1 > max) {
                    max = i - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
