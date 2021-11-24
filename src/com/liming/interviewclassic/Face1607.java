package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-05-27 21:21
 * easy 面试题 16.07. 最大数值
 */
public class Face1607 {
    //public int maximum(int a, int b) {
    //    return Math.max(a,b);
    //}

    public int maximum(int a, int b) {
        long sum = (long) a + (long) b;
        long diff = (long) a - (long) b;
        long abs = (diff ^ (diff >> 63)) - (diff >> 63);
        return (int) ((sum + abs) / 2);
    }
}
