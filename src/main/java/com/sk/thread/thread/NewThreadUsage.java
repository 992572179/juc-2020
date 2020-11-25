package com.sk.thread.thread;

public class NewThreadUsage {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("hello runnable." + i);
                }
            }
        }, "print-thread").start();
    }
}
