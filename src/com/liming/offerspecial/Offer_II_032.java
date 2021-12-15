package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-15 22:16
 * 剑指 Offer II 032. 有效的变位词
 */
public class Offer_II_032 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return false;
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            res[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (res[i] != 0) return false;
        }
        return true;
    }
}
