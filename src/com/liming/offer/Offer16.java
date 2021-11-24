package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-26 15:08
 */
public class Offer16 {
    public double myPow(double x, int n) {
        double res = 0.0;
        if (x == 0.0 && n < 0) {
            return 0.0;
        }
        long b = n;
        if (b < 0) {
            return 1.0 / pow(x, -b);
        } else {
            return pow(x, b);
        }
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            n >>= 1;
            x = x * x;
        }
        return res;
    }
}
