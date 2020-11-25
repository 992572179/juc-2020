package com.sk.thread.aqs;

/**
 * 锁的可重入
 */
public class ReentrantDemo {


    private DefinedLockReentrant lock = new DefinedLockReentrant();

    private void a(){
        lock.lock();
        System.out.println("a method...");
        b();
        lock.unlock();
    }

    private void b(){
        lock.lock();
        System.out.println("b method...");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantDemo demo = new ReentrantDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a();
            }
        }).start();
    }
}
