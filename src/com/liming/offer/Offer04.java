package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-18 15:49
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n > 0) {
            int x = 0;
            int y = matrix[0].length - 1;
            while (x != n && y >= 0) {
                if (matrix[x][y] == target) {
                    return true;
                } else {
                    if (matrix[x][y] > target) {
                        y--;
                    } else {
                        x++;
                    }
                }
            }
        }
        return false;
    }
}
