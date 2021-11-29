package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-25 19:45
 */
public class Offer_65 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        new Offer_65().add(15, 1);
    }
}
