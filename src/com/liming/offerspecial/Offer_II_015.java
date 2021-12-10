package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ltf
 * @date 2021-12-10 22:19
 */
public class Offer_II_015 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            c1[p.charAt(i) - 'a']++;
            c2[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(c1, c2)) res.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            c2[s.charAt(i - p.length()) - 'a']--;
            c2[s.charAt(i)-'a']++;
            if (Arrays.equals(c1, c2)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
