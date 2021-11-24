package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-05-06 20:51
 */
public class Face0508 {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] res = new int[length];
        for (int i = x1, width = w / 32; i <= x2; i++) {
            res[width * y + (i / 32)] |= (1 << (31 - (i % 32)));
        }
        return res;
    }
}
