package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-24 10:07
 * 剑指 Offer 16. 数值的整数次方
 */
public class Offer_16 {
    //public double myPow(double x, int n) {
    //    long b = n;// 防止int的负数最小值 变号时 溢出
    //    double res = 1.0;
    //    if (b < 0) {
    //        x = 1 / x; // 变倒数
    //        b = -b;
    //    }
    //    while (b > 0) {
    //        if ((b & 1) == 1) res *= x;
    //        b >>= 1;
    //        x *= x;
    //    }
    //    return res;
    //}
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2, x *= x) {
            if ((i & 1) != 0) res *= x;
        }
        return n < 0 ? 1.0 / res : res;
    }
}
