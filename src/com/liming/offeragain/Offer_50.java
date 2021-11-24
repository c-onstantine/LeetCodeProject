package com.liming.offeragain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-11-09 19:44
 * 剑指 Offer 50. 第一个只出现一次的字符
 */
public class Offer_50 {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
