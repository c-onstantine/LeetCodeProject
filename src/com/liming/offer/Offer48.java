package com.liming.offer;

import java.util.HashMap;

/**
 * @author ltf
 * @date 2021-03-22 20:27
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        int curlen = 0, maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = dic.getOrDefault(s.charAt(i), -1);
            dic.put(s.charAt(i), i);
            curlen = i - j > curlen ? curlen + 1 : i - j;
            maxlen = Math.max(curlen, maxlen);
        }
        return maxlen;
    }
}
