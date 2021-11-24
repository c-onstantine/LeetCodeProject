package com.liming.interviewclassic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ltf
 * @date 2021-05-10 21:25
 */
public class Face0808 {
    public String[] permutation(String S) {
        Set<String> res = new HashSet<>();
        dfs(res, S, new StringBuilder(), new boolean[S.length()]);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(Set<String> res, String s, StringBuilder sb, boolean vis[]) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!vis[i]) {
                vis[i] = true;
                sb.append(s.charAt(i));
                dfs(res, s, sb, vis);
                sb.deleteCharAt(sb.length() - 1);
                vis[i] = false;
            }
        }
    }
}
