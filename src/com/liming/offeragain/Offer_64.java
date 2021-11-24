package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-23 19:41
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Offer_64 {
    public int sumNums(int n) {
        boolean tmp = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
