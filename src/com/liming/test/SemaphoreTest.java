package com.liming.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ltf
 * @date 2021-11-05 20:31
 */
public class SemaphoreTest {
    private static final int threadcout = 200;
    public static void main(String[] args) {
        ExecutorService threadpool = Executors.newFixedThreadPool(100);
        final Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < threadcout; i++) {
            final int threadnum = i;
            threadpool.execute(()->{
                try {
                    semaphore.acquire();
                    test(threadnum);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
        threadpool.shutdown();
        System.out.println("finish");

    }
    private static void test(int threadnum) throws Exception {
        Thread.sleep(1000);
        System.out.println("threadnum:"+threadnum);
        Thread.sleep(1000);
    }
}
