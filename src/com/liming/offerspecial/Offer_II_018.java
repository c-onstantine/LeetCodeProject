package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-13 21:54
 */
public class Offer_II_018 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !check(s.charAt(l))) l++;
            while (l < r && !check(s.charAt(r))) r--;
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean check(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) return true;
        return false;
    }

    public static void main(String[] args) {
        new Offer_II_018().isPalindrome("A man, a plan, a canal: Panama");
    }
}
