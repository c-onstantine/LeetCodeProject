package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-27 20:59
 */
public class Offer_II_064 {
    Trie trie;

    /**
     * Initialize your data structure here.
     */
    public Offer_II_064() {
        trie = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            trie.insert(s);
        }
    }

    public boolean search(String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (searchWord.charAt(i) != c) {
                    if (trie.search(searchWord.substring(0, i) + c + searchWord.substring(i + 1))) {
                        return true;
                    }
                }
            }
        }
        return false;
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
            Trie.TreeNode cur = root;
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
            Trie.TreeNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    return false;
                }
                cur = cur.child[c - 'a'];
            }
            return cur.isWord;
        }
    }
}
