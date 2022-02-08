package com.liming.zijie;

/**
 * @author ltf
 * @date 2022-02-08 9:48
 */
public class Sqrtx_69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
