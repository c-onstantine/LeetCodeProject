package com.liming.offer;

/**
 * @author ltf
 * @date 2021-04-06 17:31
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
