package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-04-19 19:33
 */
public class Face0104 {
    public boolean canPermutePalindrome(String s) {
        long high = 0;
        long low = 0;
        for (char c : s.toCharArray()) {
            if (c >= 64) {
                high ^= 1L << c - 64;
            } else {
                low ^= 1L << c;
            }
        }
        return Long.bitCount(low) + Long.bitCount(high) <= 1;
    }

}
