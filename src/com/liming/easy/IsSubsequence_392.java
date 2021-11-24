package com.liming.easy;


/**
 * @author ltf
 * @date 2021-08-16 20:27
 * 392. 判断子序列 双指针  也可以用动态规划  是编辑距离的入门版本 只考虑删除
 */
public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen == 0) return true;
        if (tlen == 0) return false;
        int i = 0, j = 0;
        while (i < slen && j < tlen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == slen;
    }
}
