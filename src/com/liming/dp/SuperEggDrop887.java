package com.liming.dp;

/**
 * @author ltf
 * @date 2021-01-11 14:12
 */
public class SuperEggDrop887 {
    public int superEggDrop(int K, int N) {
        // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少仍的次数
        int[][] dp = new int[K + 1][N + 1];
        // 楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0；
        for (int i = 0; i <= K; i++) {
            dp[i][0]=0;
        }
        // 楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次；
        dp[0][1]=0;
        for (int i = 1; i <= K; i++) {
            dp[i][1]=1;
        }
        // 鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0，虽然不符合题意，但是这个值有效，它在后面的计算中会被用到；
        for (int i = 0; i <= N; i++) {
            dp[0][i]=0;
        }
        //鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度；
        for (int i = 0; i < N; i++) {
            dp[1][i]=i;
        }

        // 开始递推
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                // 在区间 [1, i] 里确定一个最优值
                int left = 1;
                int right = j;
                while (left < right) {
                    // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                    int mid = left + (right - left + 1) / 2;

                    int breakCount = dp[i-1][mid-1];
                    int notBreakCount = dp[i][j-mid];
                    if (breakCount > notBreakCount) {
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                dp[i][j] = Math.max(dp[i-1][left-1], dp[i][j-left]) + 1;
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        System.out.println(new SuperEggDrop887().superEggDrop(3, 14));
    }
}
