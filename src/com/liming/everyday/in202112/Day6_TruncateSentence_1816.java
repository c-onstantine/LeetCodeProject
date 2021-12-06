package com.liming.everyday.in202112;

/**
 * @author ltf
 * @date 2021-12-06 18:48
 */
public class Day6_TruncateSentence_1816 {
    public String truncateSentence(String s, int k) {
        int index = 0;
        while (index < s.length() && k > 0) {
            if (s.charAt(index) == ' ') k--;
            if (k > 0) index++;
        }
        return s.substring(0, index);
    }
}
