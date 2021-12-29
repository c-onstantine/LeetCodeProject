package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-29 19:57
 */
public class Offer_II_072 {
    public int mySqrt(int x) {
        int left = 1, right = x / 2, mid = 0;
        if (x == 1) right = 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
