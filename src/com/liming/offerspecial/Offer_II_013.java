package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-09 20:11
 * 前缀和
 */
public class Offer_II_013 {
    private int[][] presum;

    public Offer_II_013(int[][] matrix) {
        presum = new int[matrix.length + 1][matrix[0].length + 1];
        int rowsum = 0;
        for (int i = 0; i < matrix.length; i++) {
            rowsum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowsum += matrix[i][j];
                presum[i + 1][j + 1] = presum[i][j + 1] + rowsum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return presum[row2 + 1][col2 + 1] - presum[row2 + 1][col1] - presum[row1][col2 + 1] + presum[row1][col1];
    }
}
