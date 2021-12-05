package com.liming.everyday.in202112;

/**
 * @author ltf
 * @date 2021-12-04 15:22
 */
public class Day4_RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dic = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            dic[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (dic[ransomNote.charAt(i) - 'a'] == 0) {
                return false;
            } else {
                dic[ransomNote.charAt(i) - 'a']--;
            }
        }
        return true;
    }
}
