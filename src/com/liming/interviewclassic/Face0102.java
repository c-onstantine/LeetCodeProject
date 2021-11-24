package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-04-16 20:34
 */
public class Face0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] ints1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ints1[s1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            if ((ints1[s2.charAt(i) - 'a']--) < 0) {
                return false;
            }
        }
        return true;
    }
}
