package com.liming.interviewclassic;

import java.util.*;

/**
 * @author ltf
 * @date 2021-06-15 20:06
 * 面试题 16.20. T9键盘
 */
public class Face1620 {
    public List<String> getValidT9Words(String num, String[] words) {
        Map<Character, Character> map = new HashMap<>();
        initMap(map);
        LinkedList<String> res = new LinkedList<>();
        search:
        for (String word : words) {
            int idx = 0;
            for (char c : word.toCharArray())
                if (map.get(c) != num.charAt(idx++))
                    continue search;
            res.addLast(word);
        }
        return res;
    }

    private void initMap(Map<Character, Character> map) {
        int index = 2;
        int j = 0;
        for (int i = 0; i < 26; i++) {
            if (index == 7 || index == 9) {
                if (j == 4) {
                    j = 0;
                    index++;
                }
            } else {
                if (j == 3) {
                    j = 0;
                    index++;
                }
            }
            map.put((char) ('a' + i), (char) ('0' + index));
            j++;
        }
    }

}
