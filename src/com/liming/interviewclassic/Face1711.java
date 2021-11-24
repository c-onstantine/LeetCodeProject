package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-06-23 19:47
 */
public class Face1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int a = -1, b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
                if (b != -1) res = Math.min(res, a - b);
            } else if (words[i].equals(word2)) {
                b = i;
                if (a != -1) res = Math.min(res, b - a);
            }
        }
        return res;
    }

}
