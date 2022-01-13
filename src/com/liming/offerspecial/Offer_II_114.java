package com.liming.offerspecial;

import java.util.*;

/**
 * @author ltf
 * @date 2022-01-13 15:34
 */
public class Offer_II_114 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] in = new int[26];// 入度
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            if (!pre.equals(cur) && checkUnLegal(pre, cur)) return "";  //防止了["abc","ab"]这种不合法情况
            int min = Math.min(pre.length(), cur.length());
            for (int j = 0; j < min; j++) {
                char pc = pre.charAt(j);
                char cc = cur.charAt(j);
                if (pc != cc) { //只有字符不相等时 才有先后顺序
                    if (!map.get(pc).contains(cc)) {
                        map.get(pc).add(cc);
                        in[cc - 'a']++;
                    }
                    break;
                }
            }
        }
        Deque<Character> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (Character ch : map.keySet()) {
            if (in[ch - 'a'] == 0) queue.offer(ch);
        }
        while (!queue.isEmpty()) {
            char poll = queue.poll();
            sb.append(poll);
            for (Character ch : map.get(poll)) {
                in[ch - 'a']--;
                if (in[ch - 'a'] == 0) queue.offer(ch);
            }
        }
        return sb.length() == map.size() ? sb.toString() : "";
    }

    private boolean checkUnLegal(String s1, String s2) {
        if (s1.length() < s2.length()) return false;
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) return false;
        }
        return true;
    }
}
