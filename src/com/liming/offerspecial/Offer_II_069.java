package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-28 21:08
 * 三分法
 */
public class Offer_II_069 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int m1 = left + (right - left) / 3;
            int m2 = right - (right - left) / 3;
            if (arr[m1] > arr[m2]) right = m2 - 1;
            else left = m1 + 1;
        }
        return right;
    }

}
