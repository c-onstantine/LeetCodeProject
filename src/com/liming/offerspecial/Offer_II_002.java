package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-06 22:08
 * 直接加法模拟
 */
public class Offer_II_002 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int s1 = a.length() - 1;
        int s2 = b.length() - 1;
        int a1 = 0, b1 = 0, carry = 0, sum = 0;
        while (s1 >= 0 || s2 >= 0) {
            a1 = s1 < 0 ? 0 : a.charAt(s1) - '0';
            b1 = s2 < 0 ? 0 : b.charAt(s2) - '0';
            sum = a1 + b1 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            s1--;
            s2--;
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
