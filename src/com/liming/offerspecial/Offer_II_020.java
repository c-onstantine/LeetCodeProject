package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-14 19:53
 * 剑指 Offer II 020. 回文子字符串的个数  中心扩展法
 */
public class Offer_II_020 {
    public int countSubstrings(String s) {
        int left = 0, right = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    ans++;
                    left--;
                    right++;
                } else break;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    ans++;
                    left--;
                    right++;
                } else break;
            }
        }
        return ans;
    }
}
