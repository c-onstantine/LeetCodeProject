package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-29 20:17
 */
public class Offer_II_073 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles), mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (countTime(piles, mid) <= h) {
                if (mid == 1 || countTime(piles, mid - 1) > h) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 1;
    }

    private int countTime(int[] piles, int k) {
        int res = 0;
        for (int pile : piles) {
            res += pile / k;
            res += pile % k == 0 ? 0 : 1;
        }
        return res;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
