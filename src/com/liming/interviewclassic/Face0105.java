package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-04-16 19:44
 */
public class Face0105 {
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        if (first.equals(second)) return true;
        if ((first.length() == 1 && second.equals("")) || (second.length() == 1 && first.equals(""))) return true;
        if (first.equals("") || second.equals("")) return false;
        if (dp(first, second) <= 1) {
            return true;
        }
        return false;
    }

    private int dp(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int dp[][] = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;//边界条件，相当于word1的删除操作
        }
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;//边界条件，相当于word1的添加操作
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= length2; j++) {//下面是上面分析的递推公式
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[length1][length2];
    }
}
