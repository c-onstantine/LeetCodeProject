package com.liming.test;

/**
 * @author ltf
 * @date 2021-11-19 9:42
 */
public class CanSeeTest {
    //使用易变关键字
     static Boolean run = true;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (run) {
                //如果run为真，则一直执行
                System.out.println("aa");  // sout 中使用了synchronized 保证了可见性 因此 这时候 线程能够获取到run变量修改后的值。
            }
        }).start();

        Thread.sleep(1000);
        System.out.println("改变run的值为false");
        run = false;
    }
}
