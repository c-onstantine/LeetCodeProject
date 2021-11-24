package com.liming.offeragain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-11-14 11:10
 */
public class Offer_48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, dpi_1 = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            tmp = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i),i);
            dpi_1 = dpi_1 < i - tmp ? dpi_1 + 1 : i - tmp;
            res = Math.max(dpi_1, res);
        }
        return res;
    }
}
