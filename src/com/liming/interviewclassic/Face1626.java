package com.liming.interviewclassic;

import java.util.Stack;

/**
 * @author ltf
 * @date 2021-06-21 17:35
 */
public class Face1626 {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == ' ') {
                i++;
                continue;
            }
            char tmp = chars[i];
            if (tmp == '+' || tmp == '-' || tmp == '*' || tmp == '/') {
                i++;
                while (i < chars.length && chars[i] == ' ') i++;
            }
            int num = 0;
            while (i < chars.length && Character.isDigit(chars[i])) {
                num = num * 10 + (chars[i] - '0');
                i++;
            }
            switch (tmp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = stack.pop() * num;
                    break;
                case '/':
                    num = stack.pop() / num;
                    break;
                default:
                    break;
            }
            stack.push(num);
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Face1626().calculate(" 3/2 "));
    }
}
