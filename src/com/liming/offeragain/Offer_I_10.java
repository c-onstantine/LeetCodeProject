package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-13 9:43
 * 剑指 Offer 10- I. 斐波那契数列
 */
public class Offer_I_10 {
    public int fib(int n) {
        if (n == 0) return 0;
        int a = 1, b = 1, tmp = 1;
        for (int i = 3; i <= n; i++) {
            tmp = (a + b)%1000000007;
            b = a;
            a = tmp;
        }
        return a;
    }
}
