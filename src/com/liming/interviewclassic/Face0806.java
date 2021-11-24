package com.liming.interviewclassic;

import java.util.List;

/**
 * @author ltf
 * @date 2021-05-07 20:49
 * 汉诺塔问题
 */
public class Face0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(A, B, C, n);
    }

    private void move(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        if (n == 1) {
            C.add(A.get(A.size() - 1));
            A.remove(A.size() - 1);
            return;
        }
        move(A, C, B, n - 1);
        C.add(A.get(A.size() - 1));
        A.remove(A.size() - 1);
        move(B, A, C, n - 1);
    }
}
