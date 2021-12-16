package com.liming.offerspecial;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-12-16 19:53
 */
public class Offer_II_034 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        int curidx = 0, nextidx = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.max(words[i].length(), words[i + 1].length()); j++) {
                curidx = j >= words[i].length() ? -1 : map.get(words[i].charAt(j));
                nextidx = j >= words[i + 1].length() ? -1 : map.get(words[i + 1].charAt(j));
                if (curidx < nextidx) break;
                if (curidx > nextidx) return false;
            }
        }
        return true;
    }
}
