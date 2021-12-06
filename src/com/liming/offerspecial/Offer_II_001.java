package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-06 20:14
 * 剑指 Offer II 001. 整数除法
 */
public class Offer_II_001 {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >>> i) - b >= 0) { // a >= (b << i)
                a -= (b << i);
                res += (1 << i);
            }
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }


}
