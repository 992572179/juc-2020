package com.sk.thread.aqs;

/**
 * 死锁的栗子
 */
public class DeadLockDemo {

    //锁未实现重入功能，造成死锁
    private DefinedLockBasic lock = new DefinedLockBasic();

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
        DeadLockDemo demo = new DeadLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a();
            }
        }).start();
    }
}
