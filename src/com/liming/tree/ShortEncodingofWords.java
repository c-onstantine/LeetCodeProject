package com.liming.tree;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-06-24 20:34
 * 820. 单词的压缩编码  甜姨
 */
public class ShortEncodingofWords {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (x, y) -> y.length() - x.length());
        Trie trie = new Trie();
        int res = 0;
        for (String word : words) {
            res += trie.insert(word);
        }
        return res;
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public int insert(String word) {
            TrieNode cur = root;
            boolean isNew = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                if (cur.children[idx] == null) {
                    isNew = true;
                    cur.children[idx] = new TrieNode();
                }
                cur = cur.children[idx];
            }
            return isNew ? word.length() + 1 : 0;
        }
    }

    class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }
    }
}
