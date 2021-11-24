package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-01 17:48
 */
public class Offer19 {
    public static void main(String[] args) {
        System.out.println(new Offer19().isMatch("mississippi", "mis*is*p*."));
    }

    public boolean isMatch(String s, String p) {
        return matches(s, 0, p, 0);
    }

    private boolean matches(String s, int sp, String p, int pp) {
        if (sp == s.length() && pp == p.length()) {
            return true;
        }
        if (sp < s.length() && pp == p.length())
            return false;

        if (pp + 1 < p.length() && p.charAt(pp + 1) == '*') {
            if (sp < s.length() && pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '.')) {
                return matches(s, sp + 1, p, pp) || matches(s, sp + 1, p, pp + 2) || matches(s, sp, p, pp + 2);
            }else {
                return matches(s,sp,p,pp+2);
            }
        }
        if (sp < s.length() && pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '.')) {
            return matches(s, sp + 1, p, pp + 1);
        }
        return false;
    }
}
