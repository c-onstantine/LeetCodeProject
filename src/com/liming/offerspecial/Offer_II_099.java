package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-01-07 19:39
 */
public class Offer_II_099 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<int[]> inres = new ArrayList<>();
        while (true) {
            String s = in.nextLine();
            if (s.length() == 0) break;
            String[] split = s.split(" ");
            int[] tmp = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                tmp[i] = Integer.valueOf(split[i]);
            }
            inres.add(tmp);
        }
        int[][] arrays = inres.toArray(new int[inres.size()][]);
        new Offer_II_099().minPathSum(arrays);
    }
}
