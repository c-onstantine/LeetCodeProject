package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-07 20:00
 * 利用位运算保存 包含的字母信息
 */
public class Offer_II_005 {
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                bits[i] = bits[i] | 1 << c - 'a'; // 这一位为1 则说明这个字母出现过 数组每个元素 通过二进制保存了
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}
