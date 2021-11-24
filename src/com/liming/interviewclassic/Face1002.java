package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author ltf
 * @date 2021-05-13 20:28
 */
public class Face1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            res.computeIfAbsent(String.valueOf(tmp), x -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
