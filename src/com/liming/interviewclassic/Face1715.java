package com.liming.interviewclassic;

import java.util.*;

/**
 * @author ltf
 * @date 2021-06-25 17:43
 */
public class Face1715 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (x, y) -> {
            if (x.length() == y.length()) {
                return x.compareTo(y);
            } else {
                return y.length() - x.length();
            }
        });
        Set<String> dic = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            dic.remove(word);
            if (find(dic, word))
                return word;
        }
        return "";
    }

    private boolean find(Set<String> dic, String word) {
        if (word.length() == 0) return true;
        for (int i = 0; i < word.length(); i++) {
            if (dic.contains(word.substring(0, i + 1)) && find(dic, word.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
}
