package com.liming.everyday.in202112;

/**
 * @author ltf
 * @date 2021-12-05 10:15
 */
public class Day5_SuperPow_372 {
    private int mod = 1337;

    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    private int dfs(int a, int[] b, int deep) {
        if (deep == -1) return 1;
        return fastPower(dfs(a, b, deep - 1), 10) * fastPower(a, b[deep]) % mod;
    }

    private int fastPower(int base, int power) {
        int res = 1;
        base %= mod;
        while (power > 0) {
            if ((power & 1) == 1) res = res * base % mod;
            power >>= 1;
            base = base * base % mod;
        }
        return res;
    }
}
