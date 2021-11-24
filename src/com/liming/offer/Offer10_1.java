package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-24 11:05
 */
public class Offer10_1 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int one = 0;
        int two = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (one + two) % 1000000007;
            one = two;
            two = sum;
        }
        return sum;
    }
}
