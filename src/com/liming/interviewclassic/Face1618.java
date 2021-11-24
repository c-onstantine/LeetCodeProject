package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-06-08 20:39
 * 太难了 淦
 * 面试题 16.18. 模式匹配
 */
public class Face1618 {
    public boolean patternMatching(String pattern, String value) {
        if (value.length() == 0) {
            int i = 0;
            while (i < pattern.length() && pattern.charAt(i) == pattern.charAt(0)) i++;
            return i == pattern.length();
        }
        int n = pattern.length(), m = value.length();
        int[] cnt = {0, 0};
        for (int i = 0; i < n; i++) {
            cnt[pattern.charAt(i) - 'a']++;
        }
        if (cnt[0] == 0) {
            return deal(value, cnt[1]);
        } else if (cnt[1] == 0) {
            return deal(value, cnt[0]);
        }
        if (deal(value, cnt[0])) return true;
        if (deal(value, cnt[1])) return true;

        for (int lena = 1; lena * cnt[0] <= m - cnt[1]; lena++) {
            if ((m - cnt[0] * lena) % cnt[1] != 0) continue;
            int lenb = (m - cnt[0] * lena) / cnt[1];
            if (check(pattern, value, lena, lenb)) return true;
        }
        return false;
    }

    private boolean deal(String value, int k) {
        int m = value.length();
        if (m % k != 0) return false;
        int len = m / k;
        for (int i = len; i < m; i += len) {
            if (!value.substring(0, len).equals(value.substring(i, i + len))) return false;
        }
        return true;
    }

    private boolean check(String pattern, String value, int lena, int lenb) {
        String[] sub = {"", ""};
        for (int i = 0, j = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                if ("".equals(sub[0])) {
                    sub[0] = value.substring(j, j + lena);
                } else if (!sub[0].equals(value.substring(j, j + lena))) return false;
                j += lena;
            } else if (pattern.charAt(i) == 'b') {
                if ("".equals(sub[1])) {
                    sub[1] = value.substring(j, j + lenb);
                } else if (!sub[1].equals(value.substring(j, j + lenb))) return false;
                j += lenb;
            }
        }
        return sub[0] != sub[1];
    }
}
