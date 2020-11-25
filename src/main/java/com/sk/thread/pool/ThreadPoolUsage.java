package com.sk.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUsage {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory());


        for (int i = 0; i < 25; i++) {
            pool.execute(() -> System.out.println("working............"));
        }


//        pool.shutdown();
//        pool.shutdownNow();

    }
}
