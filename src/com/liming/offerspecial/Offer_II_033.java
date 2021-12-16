package com.liming.offerspecial;

import java.util.*;

/**
 * @author ltf
 * @date 2021-12-16 19:32
 */
public class Offer_II_033 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arrs = str.toCharArray();
            Arrays.sort(arrs);
            String key = new String(arrs);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
