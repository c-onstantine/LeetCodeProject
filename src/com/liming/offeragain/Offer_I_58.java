package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-17 21:52
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
public class Offer_I_58 {
    public String reverseWords(String s) {
        String[] chars = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if ("".equals(chars[i])) continue;
            sb.append(chars[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Offer_I_58().reverseWords("a good   example");
    }
}
