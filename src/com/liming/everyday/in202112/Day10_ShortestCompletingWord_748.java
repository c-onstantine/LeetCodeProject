package com.liming.everyday.in202112;

/**
 * @author ltf
 * @date 2021-12-10 15:07
 */
public class Day10_ShortestCompletingWord_748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licenseNum = getCharNum(licensePlate);
        String res = null;
        int[] tmp = null;
        boolean flag = false;
        for (String word : words) {
            tmp = getCharNum(word);
            flag = false;
            for (int i = 0; i < 26; i++) {
                if (licenseNum[i] > tmp[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag && (res == null || res.length() > word.length())) res = word;
        }
        return res;
    }

    private int[] getCharNum(String licensePlate) {
        int[] res = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                res[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                res[c - 'A']++;
            }
        }
        return res;
    }
}
