package com.sk.thread.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 使用 synchronized 关键字，实现加锁 解锁
 * 实现锁的重入功能
 */
public class DefinedLockReentrant implements Lock {

    private boolean isLocked = false;
    private int lockCount = 0;
    private Thread lockBy = null;

    @Override
    public synchronized void lock() {
        Thread currentThread  = Thread.currentThread();
        while (isLocked && currentThread!= lockBy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockBy = currentThread;
        lockCount++;

    }

    @Override
    public synchronized void unlock() {
        Thread currentThread  = Thread.currentThread();
        if (currentThread == lockBy){
            lockCount --;
            if (lockCount == 0){
                isLocked = false;
                lockBy = null;
                notify();
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
