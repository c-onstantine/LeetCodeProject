package com.liming.offer;

import java.util.HashMap;

/**
 * @author ltf
 * @date 2021-03-23 13:58
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cnt.containsKey(c)) {
                cnt.put(c, cnt.get(c) + 1);
            } else {
                cnt.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = cnt.get(c);
            if (count == 1) {
                return c;
            }
        }
        return ' ';
    }
}
