package com.liming.easy;

/**
 * @author ltf
 * @date 2021-10-14 20:24
 * 7. 整数反转
 */
public class ReverseInteger_7 {
    public int reverse(int x) {
        int res = 0;
        int tmp = 0;
        int last = 0;
        while (x != 0) {
            tmp = x % 10;
            last = res;
            res = res * 10 + tmp;
            if (last != res / 10) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }
}
