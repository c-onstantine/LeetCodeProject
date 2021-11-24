package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-04-19 19:24
 */
public class Face0103 {
    public String replaceSpaces(String S, int length) {
        return S.substring(0, length).replaceAll(" ", "%20");
    }
}
