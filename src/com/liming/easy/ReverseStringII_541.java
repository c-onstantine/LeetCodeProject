package com.liming.easy;

/**
 * @author ltf
 * @date 2021-08-20 11:34
 * 541. 反转字符串 II
 */
public class ReverseStringII_541 {
    public String reverseStr(String s, int k) {
        int i = 0, j = k, pre = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        while (j < len) {
            i++;
            j++;
            if (i % k == 0) {
                sb.append(new StringBuilder(s.substring(i - k, i)).reverse());
                sb.append(s.substring(i, i + k));
                pre = j;
                i = j;
                j = j + k;
            }
        }
        if (s.length() - pre < k) {
            sb.append(new StringBuilder(s.substring(pre)).reverse());
        } else if (s.length() - pre < 2 * k) {
            sb.append(new StringBuilder(s.substring(pre, pre + k)).reverse());
            sb.append(s.substring(pre + k));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new ReverseStringII_541().reverseStr("abcdefg", 2);//"bacdfeg"
    }
}
