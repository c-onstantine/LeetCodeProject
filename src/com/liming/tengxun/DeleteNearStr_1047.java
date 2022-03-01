package com.liming.tengxun;

/**
 * @author ltf
 * @date 2022-02-21 8:45
 */
public class DeleteNearStr_1047 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int top = -1;
        for(int i = 0; i < s.length(); i++){
            if(top >=0 && sb.charAt(top) == s.charAt(i)){
                sb.deleteCharAt(top);
                top--;
            }else{
                sb.append(s.charAt(i));
                top++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new DeleteNearStr_1047().removeDuplicates("abbaca");
    }
}
