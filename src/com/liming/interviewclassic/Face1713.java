package com.liming.interviewclassic;

import java.util.*;

/**
 * @author ltf
 * @date 2021-06-23 21:24
 */
public class Face1713 {
    public int respace(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>(Arrays.asList(dictionary));
        int len = sentence.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (dic.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[j], dp[i]);
                }
            }
        }
        return dp[len];
    }

    // 解法2 trie 树 优化
    public int respace1(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        int len = sentence.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;
            for (Integer idx : trie.search(sentence, i - 1)) {
                dp[i] = Math.min(dp[i], dp[idx]);
            }
        }
        return dp[len];
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            cur.isWord = true;
        }

        public List<Integer> search(String sen, int endpos) {
            List<Integer> res = new ArrayList<>();
            TrieNode cur = root;
            for (int i = endpos; i >= 0; i--) {
                int c = sen.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    break;
                }
                cur = cur.children[c];
                if (cur.isWord) {
                    res.add(i);
                }
            }
            return res;
        }
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }
    }
}
