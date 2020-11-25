package com.sk.thread.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * 交替打印1a 2b 3c 4d 5e
 */
public class LockSupportUsage {

    private static Thread T1, T2;

    public static void main(String[] args) {
        char[] muns = "12345".toCharArray();
        char[] chars = "abcde".toCharArray();

        T1 = new Thread(() -> {
            for (char c : muns) {
                System.out.println(c);
                LockSupport.unpark(T2);
                LockSupport.park();
            }
        }, "T1");

        T2 = new Thread(() -> {
            for (char c : chars) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(T1);
            }
        }, "T2");

        T1.start();
        T2.start();
    }
}
