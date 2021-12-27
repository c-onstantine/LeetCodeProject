package com.liming.offerspecial;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-12-27 19:30
 * 前缀树实现
 */
public class Offer_II_062 {
    Map<Character, Offer_II_062> child = new HashMap<>();
    boolean isWord = false;

    /**
     * Initialize your data structure here.
     */
    public Offer_II_062() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Offer_II_062 cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.child.containsKey(word.charAt(i))) {
                cur.child.put(word.charAt(i), new Offer_II_062());
            }
            cur = cur.child.get(word.charAt(i));
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Offer_II_062 cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.child.containsKey(c)) {
                return false;
            }
            cur = cur.child.get(c);
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Offer_II_062 cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.child.containsKey(c)) {
                return false;
            }
            cur = cur.child.get(c);
        }
        return true;
    }

    private class Trie {
        TreeNode root;

        private class TreeNode {
            TreeNode[] child;
            boolean isWord;

            public TreeNode() {
                child = new TreeNode[26];
            }
        }

        public Trie() {
            root = new TreeNode();
        }


        public void insert(String word) {
            TreeNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TreeNode();
                }
                cur = cur.child[c - 'a'];
            }
            cur.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TreeNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    return false;
                }
                cur = cur.child[c - 'a'];
            }
            return cur.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TreeNode cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    return false;
                }
                cur = cur.child[c - 'a'];
            }
            return true;
        }
    }
}


