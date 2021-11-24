package com.liming.interviewclassic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-05-24 18:57
 * 面试题 16.02. 单词频率
 */
public class Face1602 {
    private Map<String, Integer> map;

    public Face1602(String[] book) {
        map = new HashMap<>();
        for (String s : book) {
            map.compute(s, (k, v) -> {
                if (v == null) {
                    v = 1;
                } else {
                    v += 1;
                }
                return v;
            });
        }
    }

    public int get(String word) {
        return map.get(word) == null ? 0 : map.get(word);
    }

    public static void main(String[] args) {

    }
}
