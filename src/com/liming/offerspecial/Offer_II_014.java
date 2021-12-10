package com.liming.offerspecial;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-12-10 17:57
 */
public class Offer_II_014 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(c1, c2)) return true;
            c2[s2.charAt(i - s1.length()) - 'a']--;
            c2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(c1, c2);
    }
}
