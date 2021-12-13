package com.liming.offerspecial;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-12-13 14:50
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 */
public class Offer_II_016 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1); // 原来出现过 则需要移动窗口
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
