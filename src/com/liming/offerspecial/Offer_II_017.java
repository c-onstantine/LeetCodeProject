package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-13 20:15
 * 剑指 Offer II 017. 含有所有字符的最短字符串
 */
public class Offer_II_017 {
    public String minWindow(String s, String t) {
        int[] window = new int[128]; // 字母窗口 记录t中每个字母出现次数
        for (int i = 0; i < t.length(); i++) {
            window[t.charAt(i)]++;
        }
        int l = 0, r = 0, count = t.length(), min = Integer.MAX_VALUE, index = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (window[c] > 0) {
                count--;
            }
            window[c]--;
            if (count == 0) {
                while (l < r && window[s.charAt(l)] < 0) {
                    window[s.charAt(l++)]++;
                }
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    index = l;
                }
                //继续移动窗口 让count恢复一个 要遍历完所有s 才能找到最小
                window[s.charAt(l++)]++;
                count++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(index, index + min);
    }
}
