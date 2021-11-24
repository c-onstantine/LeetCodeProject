package com.liming.offer;

/**
 * @author ltf
 * @date 2021-04-07 14:28
 */
public class Offer64 {
    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
