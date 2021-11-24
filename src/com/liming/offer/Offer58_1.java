package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-30 20:46
 */
public class Offer58_1 {
    public String reverseWords(String s) {
        String trim = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] s1 = trim.split(" ");
        System.out.println(s1.length);
        for (int i = s1.length - 1; i >= 0; i--) {
            if("".equals(s1[i])){
                continue;
            }
            sb.append(s1[i].trim() + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s= "a good   example";
        System.out.println(new Offer58_1().reverseWords(s));
    }
}
