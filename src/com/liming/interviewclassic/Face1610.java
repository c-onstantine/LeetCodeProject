package com.liming.interviewclassic;


/**
 * @author ltf
 * @date 2021-06-03 20:27
 */
public class Face1610 {
    public int maxAliveYear(int[] birth, int[] death) {
        int n = birth.length;
        int[] s = new int[110];
        for (int i = 0; i < n; i++) {
            s[birth[i] - 1900] += 1;
            s[death[i] - 1900 + 1] -= 1;
        }
        int max = Integer.MIN_VALUE;
        int id = 0;
        for (int i = 1; i <= 110; i++) {
            s[i] += s[i - 1];
            if (max < s[i]) {
                max = s[i];
                id = i;
            }
        }
        if (id == 1 && s[0] == s[1]) {
            return 1900;
        } else {
            return id + 1900;
        }
    }
}
