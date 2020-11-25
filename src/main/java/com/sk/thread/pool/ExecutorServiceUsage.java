package com.sk.thread.pool;

import java.util.concurrent.*;

public class ExecutorServiceUsage {

    static class Task implements Callable<String>{

        @Override
        public String call() {
            System.out.println("callable ......");
            return "success";
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        Future<String> future = es.submit(new Task());
        try {
            System.out.println("future: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
