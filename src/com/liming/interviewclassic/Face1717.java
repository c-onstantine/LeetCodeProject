package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-06-28 11:38
 */
public class Face1717 {
    public int[][] multiSearch(String big, String[] smalls) {
        Map<String, ArrayList<Integer>> res = new HashMap<>();
        Trie trie = new Trie();
        for (String small : smalls) {
            res.computeIfAbsent(small, (x) -> new ArrayList<>());
            trie.insert(small);
        }
        for (int i = 0; i < big.length(); i++) {
            trie.search(i, big, res);
        }
        int[][] small = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            small[i] = res.get(smalls[i]).stream().mapToInt(Integer::valueOf).toArray();
        }
        return small;
    }

    private class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.trieNodes[c] == null) {
                    cur.trieNodes[c] = new TrieNode();
                }
                cur = cur.trieNodes[c];
            }
            cur.isword = true;
        }

        public void search(int endpos, String big, Map<String, ArrayList<Integer>> map) {
            TrieNode cur = root;
            StringBuilder sb = new StringBuilder();
            for (int i = endpos; i >= 0; i--) {
                int c = big.charAt(i) - 'a';
                if (cur.trieNodes[c] == null) {
                    break;
                }
                sb.insert(0, big.charAt(i));
                cur = cur.trieNodes[c];
                if (cur.isword) {
                    map.get(sb.toString()).add(i);
                }
            }
        }
    }

    private class TrieNode {
        TrieNode[] trieNodes = new TrieNode[26];
        boolean isword;

        public TrieNode() {
        }
    }
}
