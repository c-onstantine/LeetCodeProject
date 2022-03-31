package com.liming.huawei.bishi;

import java.util.Scanner;

/**
 * @author ltf
 * @date 2022-03-23 20:41
 */
public class Test3 {

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            int index = 0;
            while (index < s.length() - 1) {
                String tag = s.substring(index, index + 2);
                String len = s.substring(index + 2, index + 4);
                int length = HexToTen(len);
                int tagnum = HexToTen(tag);
                if (tagnum == tmp) {
                    System.out.println(length + " " + (index + 4) / 2);
                    break;
                } else {
                    index = index + 4 + length * 2;
                }
            }
            if (index >= s.length() - 1) {
                System.out.println(0 + " " + 0);
            }
        }
    }

    private static int HexToTen(String str) {
        int base = 1;
        int res = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res += (str.charAt(i) - '0') * base;
            } else if (str.charAt(i) == 'A') {
                res += 10 * base;
            } else if (str.charAt(i) == 'B') {
                res += 11 * base;
            } else if (str.charAt(i) == 'C') {
                res += 12 * base;
            } else if (str.charAt(i) == 'D') {
                res += 13 * base;
            } else if (str.charAt(i) == 'E') {
                res += 14 * base;
            } else if (str.charAt(i) == 'F') {
                res += 15 * base;
            }
            base *= 16;
        }
        return res;
    }
}
