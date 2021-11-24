package com.liming.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ltf
 * @date 2021-10-30 11:07
 */
public class ABAProblemTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        new Thread(()->{
            int curval = atomicInteger.get();
            System.out.println(Thread.currentThread().getName() + " ------ currentValue=" + curval);
            // 模拟处理业务逻辑
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean setResult = atomicInteger.compareAndSet(1, 2);
            System.out.println(Thread.currentThread().getName()
                    + "----- currentValue=" + curval
                    + ",----- finalValue=" + atomicInteger.get()
                    + ",----- compareAndSet Result=" + setResult);
        }).start();
        //保证上面的线程先启动
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            // 先设置为2 又设置回1
            int curval = atomicInteger.get();
            boolean casResult = atomicInteger.compareAndSet(1, 2);
            System.out.println(Thread.currentThread().getName()
                    + "----- currentValue=" + curval
                    + ",----- finalValue=" + atomicInteger.get()
                    + ",----- compareAndSet Result=" + casResult);

            curval = atomicInteger.get();
            casResult = atomicInteger.compareAndSet(2, 1);
            System.out.println(Thread.currentThread().getName()
                    + "----- currentValue=" + curval
                    + ",----- finalValue=" + atomicInteger.get()
                    + ",----- compareAndSet Result=" + casResult);
        }).start();
    }
}
