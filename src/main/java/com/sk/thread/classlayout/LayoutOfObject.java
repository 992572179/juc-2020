package com.sk.thread.classlayout;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * new Object()需要的内存
 * @author wangzy
 */
public class LayoutOfObject {

    public static void main(String[] args) {
        try {
            //等待JVM启用偏向锁
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object obj = new Object();
//        obj.hashCode();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        System.out.println("-------------------------------------------");

        synchronized (obj){
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }

//        Lock locksupport = new ReentrantLock();
//        locksupport.locksupport();
//        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
//        locksupport.unlock();

        /**
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         *
         * --------------不使用指针压缩
         *
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           00 1c b3 17 (00000000 00011100 10110011 00010111) (397614080)
         *      12     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
         *
         * -------------持有锁后-------------
         *
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           88 f3 b2 02 (10001000 11110011 10110010 00000010) (45282184)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         * */

    }
}
