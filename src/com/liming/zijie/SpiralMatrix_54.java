package com.liming.zijie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-10-10 16:43
 * 54. 螺旋矩阵 定义矩阵的上下左右边界 一边遍历 一边修改边界
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int i = 0;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) break;
            for (i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) break;
            for (i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) break;
            for (i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }
}
