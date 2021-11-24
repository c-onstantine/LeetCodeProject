package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-05-07 20:33
 */
public class Face0805 {
    public int multiply(int A, int B) {
        int x = Math.min(A, B);
        int y = Math.max(A, B);
        int res = 0;
        for (int i = 0; x != 0; i++) {
            if ((x & 1) == 1) {
                res += (y << i);
            }
            x >>= 1;
        }
        return res;
    }
}
