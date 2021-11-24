package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-25 17:08
 */
public class Offer14 {
    public int cuttingRope(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int inof3 = n / 3;
        if (n - inof3 * 3 == 1)
            inof3 -= 1;
        int inof2 = (n - inof3 * 3) / 2;
        return (int) (Math.pow(3, inof3) * Math.pow(2, inof2));
    }
}
