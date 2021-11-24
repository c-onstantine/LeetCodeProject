package com.liming.tanxin;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-09-07 21:11
 */
public class AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (index < g.length && g[index] <= s[i]) {
                index++;
            }
        }
        return index;
    }
}
