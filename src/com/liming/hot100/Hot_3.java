package com.liming.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2022-02-01 11:41
 */
public class Hot_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
