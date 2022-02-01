package com.liming.zijie;

/**
 * @author ltf
 * @date 2022-01-29 16:49
 * 43. 字符串相乘
 */
public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append("0");
            }
            int n2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0 || carry > 0; j--) {

                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int x = n1 * n2 + carry;
                sb.append(x % 10);
                carry = x / 10;
            }
            res = addString(res, sb.reverse().toString());
        }
        return res;
    }

    private String addString(String res, String tmp) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = res.length() - 1, j = tmp.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int x = i < 0 ? 0 : res.charAt(i) - '0';
            int y = j < 0 ? 0 : tmp.charAt(i) - '0';
            int r = x + y + carry;
            sb.append(r % 10);
            carry = r / 10;
        }
        return sb.reverse().toString();
    }
}
