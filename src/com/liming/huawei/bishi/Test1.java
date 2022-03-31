//package com.liming.huawei.bishi;
//
//import java.util.Scanner;
//
///**
// * @author ltf
// * @date 2022-03-23 19:26
// */
//public class Test1 {
//
//    public static void main(String[] args) {
//        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = sc.nextInt();
//        }
//        int k = sc.nextInt();
//        int cur = 0;
//        int left = 1;
//        int right = cur + arr[0];
//        int res = 0;
//        while(true){
//            int[] tmp = getSubMax(arr,left,right);
//            res++;
//            cur = tmp[1];
//            int maxlen = tmp[2];
//            if(cur == arr.length - 1){
//                System.out.println(res);
//                return;
//            }
//            if(maxlen >= arr.length - 1){
//                res++;
//                System.out.println(res);
//                return;
//            }
//            if(tmp[0] != 0){
//                left = cur + 1;
//                right = cur + arr[cur];
//            }else if(tmp[0] == 0 && cur < arr.length - 1){
//                System.out.println(-1);
//                return;
//            }
//        }
//    }
//    private static int[] getSubMax(int[] num,int left,int right){
//        int max = 0;
//        int index = 0;
//        int maxlen = 0;
//        for(int i = left; i <= right && i < num.length; i++){
//
//            if(maxlen < i + num[i]){
//                max = num[i];
//                index = i;
//                maxlen = i + num[i];
//            }
//        }
//        return new int[]{max,index,maxlen};
//    }
//    public static void main(String[] args) {
//        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        //6
//        //2 1 5 6 2 3
//        //3
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int k = sc.nextInt();
//        int cur = 0;
//        int left = 1;
//        int right = cur + arr[0];
//        int res = 0;
//        while (true) {
//            int[] tmp = getSubMax(arr, left, right);
//            res++;
//            if (tmp[0] != 0) {
//                cur = tmp[1];
//                left = cur + 1;
//                right = cur + arr[cur];
//                if (right == arr.length - 1) {
//                    System.out.println(res);
//                    return;
//                } else if (right >= arr.length) {
//                    res++;
//                    System.out.println(res);
//                    return;
//                }
//            } else if (tmp[0] == 0 && cur != arr.length - 1) {
//                System.out.println(-1);
//                return;
//            }
//        }
//    }
//
//    private static int[] getSubMax(int[] num, int left, int right) {
//        int max = 0;
//        int index = 0;
//        for (int i = left; i <= right && i < num.length; i++) {
//            if (num[i] > max) {
//                max = num[i];
//                index = i;
//            }
//        }
//        return new int[]{max, index};
//    }
//}
