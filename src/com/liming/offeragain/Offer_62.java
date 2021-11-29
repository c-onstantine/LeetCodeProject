package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-29 20:42
 * 约瑟夫环 反推
 */
public class Offer_62 {
    public int lastRemaining(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }
}
