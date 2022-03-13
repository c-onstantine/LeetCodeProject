package com.liming.sortlearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ltf
 * @date 2022-03-05 10:51
 */
public class Test {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a, b)->a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int res = 1;
        for(int i = 1; i < envelopes.length; i++){
            for(int j = 0; j < i; j++){
                if(check(envelopes,j,i)){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                res = Math.max(res,dp[i]);
            }
        }
        return res;
    }
    private boolean check(int[][] envelopes,int x,int y){
        return envelopes[x][0] < envelopes[y][0] && envelopes[x][1] < envelopes[y][1];
    }
    private static class Key implements Comparable<Key>{
        private int key;
        private int seq;

        public Key(int key, int seq) {
            this.key = key;
            this.seq = seq;
        }

        @Override
        public int compareTo(Key o) {
            if(this.key == o.key){
                return seq - o.seq;
            }else{
                return key - o.key;
            }
        }

        @Override
        public String toString() {
            return "Key{" +
                    "key=" + key +
                    ", seq=" + seq +
                    '}';
        }
    }
    public static void main(String[] args){
        //new Thread(()->{
        //    int i = 1 / 0;
        //    System.out.println("11");
        //}).start();


        // 排序学习
        Key[] k = new Key[]{new Key(2,4),new Key(1,3),new Key(1,2)};
        Arrays.sort(k,(a,b)->b.seq - a.seq);
        Arrays.stream(k).forEach(System.out::println);

        List<Key> list = new ArrayList<>();
        list.add(new Key(2,4));
        list.add(new Key(4,2));
        list.add(new Key(3,1));
        list.add(new Key(2,5));
        Collections.sort(list,(x,y) ->{
            return y.key - x.key;
        });
        System.out.println(list);




        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //int x = n, y = n, z = n;
        //int m = sc.nextInt();
        //sc.nextLine();
        //String str = sc.nextLine();
        //String[] op = str.split(" ");
        //int [] opnum = new int[m];
        //for(int i = 0; i < m; i++){
        //    opnum[i] = sc.nextInt();
        //}
        //int max = 0;
        //PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{
        //    return b.compareTo(a);
        //});
        //int curcut = 0;
        //int left = x * y *z;
        //queue.offer(left);
        //for(int i = 0; i < m; i++){
        //    if(op[i].equals("x")){
        //        x-=opnum[i];
        //        curcut = opnum[i] * y *z;
        //        if(queue.peek() == left){
        //            queue.poll();
        //        }
        //
        //        left = x*y*z;
        //
        //    }else if(op[i].equals("y")){
        //        y-=opnum[i];
        //        curcut = opnum[i] * x *z;
        //        if(queue.peek() == left){
        //            queue.poll();
        //        }
        //        left = x*y*z;
        //    }else if(op[i].equals("z")){
        //        z-=opnum[i];
        //        curcut = opnum[i]*x*y;
        //        if(queue.peek() == left){
        //            queue.poll();
        //        }
        //        left = x*y*z;
        //    }
        //    queue.offer(curcut);
        //    queue.offer(left);
        //    System.out.println(queue.peek());
        //}
    }
}
