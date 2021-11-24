package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-14 10:42
 * 剑指 Offer 46. 把数字翻译成字符串
 */
public class Offer_46 {
    public int translateNum(int num) {
        int a = 1, b = 1, y = num % 10, tmp = 0, c = 0, x = 0;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            tmp = 10 * x + y;
            c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
