package com.liming.offerspecial;

import java.util.List;

/**
 * @author ltf
 * @date 2021-12-27 20:08
 */
public class Offer_II_063 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            String prefix = trie.prefix(s);
            sb.append("".equals(prefix) ? s : prefix);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private class Trie {
        TreeNode root;

        private class TreeNode {
            TreeNode[] child = new TreeNode[26];
            boolean isWord = false;
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

        public String prefix(String word) {
            StringBuilder sb = new StringBuilder();
            TreeNode cur = root;
            for (char c : word.toCharArray()) {
                sb.append(c);
                if (cur.child[c - 'a'] == null) return "";
                if (cur.child[c - 'a'].isWord) {  // 题目要求 如果继承词有许多可以形成它的词根，则用最短的词根替换它。 所以当前缀已经是一个词根时，立即返回则是最短
                    return sb.toString();
                }
                cur = cur.child[c - 'a'];
            }
            return sb.toString();
        }
    }
}
