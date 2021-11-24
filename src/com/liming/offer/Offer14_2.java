package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-26 9:43
 */
public class Offer14_2 {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }

    private int quickmi(int base, int power) {
        int res = 0;
        while (power > 0) {
            if ((power & 1) == 1) {
                res = (res * base) % 1000000007;
            }
            power = power >> 1;
            base = (base * base) % 1000000007;
        }
        return res;
    }
}
