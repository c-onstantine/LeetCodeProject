package com.liming.zijie;

import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-02-24 19:29
 * <p>
 * 给定任意一个字符串str=“…abcxxxdfdllyx…”，请编写一个方法func(str)，经过这个方法处理的str不再包含驼峰字符串。（考察时间10分钟）
 * 附：驼峰字符串定义，由3个字符组成，第1个和第3个字符相同且不同于第2个，例如dfd。
 */
public class TXTest {
    public static void main(String[] args) {
        System.out.println(func("cabfbcfg"));
        Scanner sc = new Scanner(System.in);

    }

    private static String func(String str) {
        // 长度小于3 不可能是驼峰字符串
        if (str.length() < 3) return str;
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < stringBuilder.length() - 2; i++) {
            if (stringBuilder.charAt(i) == stringBuilder.charAt(i + 2) && stringBuilder.charAt(i) != stringBuilder.charAt(i + 1)) {
                stringBuilder.delete(i, i + 3);
                i = -1;
            }
        }
        return stringBuilder.toString();
    }
}
