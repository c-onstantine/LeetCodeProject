package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-27 21:26
 */
public class Offer_II_065 {
    int total = 0;

    public int minimumLengthEncoding(String[] words) {
        Trie tree = new Trie();
        for (String word : words) {
            tree.insert(word);
        }
        dfs(tree, 1);
        return total;
    }

    private void dfs(Trie root, int len) {
        boolean isLeaf = true;
        for (Trie child : root.child) {
            if (child != null) {
                isLeaf = false;
                dfs(child, len + 1);
            }
        }
        if (isLeaf) {
            total += len;
        }
    }

    private class Trie {
        Trie[] child = new Trie[26];

        public void insert(String word) {
            Trie cur = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new Trie();
                }
                cur = cur.child[c - 'a'];
            }
        }
    }
}
