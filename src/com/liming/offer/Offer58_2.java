package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-31 14:38
 */
public class Offer58_2 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
