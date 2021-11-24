package com.liming.zijie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-09-16 22:15
 * 滑动窗口问题 ，一个窗口 当进入重复数据时，就将窗口中数据从左侧移除 直到没有重复。
 */
public class LongestSubWithouRepeatChar_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> win = new HashMap<>();
        int max = 0;
        int left = 0; // 窗口最左端
        for (int i = 0; i < s.length(); i++) {
            if (win.containsKey(s.charAt(i))) {
                left = Math.max(left, win.get(s.charAt(i)) + 1);
            }
            win.put(s.charAt(i), i);
            max = Math.max(max, win.get(s.charAt(i)) - left + 1);
        }
        return max;
    }
}
