package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-10-16 14:37
 * 5. 最长回文子串
 */
public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;
        int[] res = new int[2];
        for (int i = 0; i < length - 1; i++) {
            int[] t1 = spread(s, i, i);//重合下标 奇数回文
            int[] t2 = spread(s, i, i + 1);//偶数回文
            int[] max = t1[1] > t2[1] ? t1 : t2;
            if (res[1] < max[1]) {
                res = max;
            }
        }
        return s.substring(res[0], res[0] + res[1]);
    }

    private int[] spread(String str, int left, int right) {
        int length = str.length();
        while (left >= 0 && right < length) {
            if (str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right - left - 1};
    }
}
