package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-22 13:57
 */
public class Offer44 {
    public int findNthDigit(int n) {
        int digit = 1;
        long count = 9;
        long start = 1;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = start * 9 * digit;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
