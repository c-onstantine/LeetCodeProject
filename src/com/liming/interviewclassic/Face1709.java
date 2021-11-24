package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-06-23 16:36
 */
public class Face1709 {
    public int getKthMagicNumber(int k) {
        int[] res = new int[k];
        res[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++) {
            res[i] = Math.min(Math.min(res[p3] * 3, res[p5]*5), res[p7] * 7);
            if (res[i] == res[p3] * 3) {
                p3++;
            }
            if (res[i] == res[p5] * 5) {
                p5++;
            }
            if (res[i] == res[p7] * 7) {
                p7++;
            }
        }
        return res[k - 1];
    }
}
