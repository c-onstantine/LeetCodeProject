package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-10-11 19:55
 */
public class AddStrings_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        // up 进位
        int n1 = 0, n2 = 0, up = 0;
        int tmp = 0;
        while (l1 >= 0 || l2 >= 0) {
            n1 = l1 >= 0 ? num1.charAt(l1--) - '0' : 0;
            n2 = l2 >= 0 ? num2.charAt(l2--) - '0' : 0;
            tmp = n1 + n2 + up;
            up = tmp / 10;
            tmp = tmp % 10;
            sb.insert(0, tmp);
        }
        if (up != 0) sb.insert(0, up);
        return sb.toString();
    }

    //错误算法
    //public String addStrings1(String num1,String num2){
    //    int carry = 0;
    //    int i = num1.length() - 1, j = num2.length() - 1;
    //    String res = "";
    //    while (i >= 0 || j >= 0 || carry != 0){
    //        int x = i >= 0? num1.charAt(i) - '0' : 0;
    //        int y = j >= 0? num2.charAt(j) - '0' : 0;
    //        int tmp = x + y + carry;
    //        res += '0' + tmp % 10;
    //        carry = tmp / 10;
    //        i--;
    //        j--;
    //    }
    //    return new StringBuilder(res).reverse().toString();
    //}

    public static void main(String[] args) {
        System.out.println(new AddStrings_415().addStrings("12", "99"));
    }
}
