package com.liming.hard;

/**
 * @author ltf
 * @date 2022-03-14 15:42
 */
public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int count = t.length();
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int startIndex = 0;
        while (right < s.length()) {
            if (need[s.charAt(right)] > 0) {
                count--;
            }
            need[s.charAt(right)]--;
            if (count == 0) {
                while (left < right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)]++;
                    left++;
                }
                if (min > right - left + 1) {
                    min = right - left + 1;
                    startIndex = left;
                }
                count++;
                need[s.charAt(left)]++;
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(startIndex,startIndex + min);
    }
}
