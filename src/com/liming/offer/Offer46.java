package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-22 15:08
 */
public class Offer46 {
    public int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = x * 10 + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
