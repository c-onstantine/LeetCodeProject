package com.liming.huawei.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-03-23 16:03
 */
public class Test3 {
    private static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        Arrays.sort(chars);
        dfs(chars, 0, new boolean[chars.length]);
        System.out.println(res);
    }

    private static void dfs(char[] chars, int deep, boolean[] vis) {
        if (deep == chars.length - 1) {
            res++;
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i - 1] == chars[i] && vis[i - 1] == false) {
                continue;
            }
            if (vis[i] == false) {
                vis[i] = true;
                dfs(chars, deep + 1, vis);
                vis[i] = false;
            }
        }
    }
}
