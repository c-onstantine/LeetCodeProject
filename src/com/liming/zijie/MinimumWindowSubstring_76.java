package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-09-18 11:36
 * 也是滑动窗口问题
 */
public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        //    判空 题目数据不包含 就不写了
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int l = 0, r = 0, min = Integer.MAX_VALUE, index = 0, cnt = t.length();
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {
                cnt--;
            }
            need[c]--;
            if (cnt == 0) {
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++;
                }
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    index = l;
                }
                need[s.charAt(l)]++;
                l++;
                cnt++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(index, index + min);
    }
}
