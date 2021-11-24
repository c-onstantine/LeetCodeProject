package com.liming.mietun;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ltf
 * @date 2021-11-02 21:25
 * 128. 最长连续序列
 */
public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int curnum = i;
                int curlen = 1;
                while (set.contains(curnum + 1)) {
                    curnum++;
                    curlen++;
                }
                maxLen = Math.max(maxLen, curlen);
            }
        }
        return maxLen;
    }
}
