package com.liming.dp;

import java.util.List;

/**
 * @author ltf
 * @date 2021-08-15 12:30
 * 139. 单词拆分
 */
public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && wordDict.contains(sub)) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
