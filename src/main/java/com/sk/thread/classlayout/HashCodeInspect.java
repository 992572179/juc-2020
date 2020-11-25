package com.sk.thread.classlayout;

import org.openjdk.jol.info.ClassLayout;

public class HashCodeInspect {

    public static void main(String[] args) {
        Object o1 = new Object();
        System.out.println(ClassLayout.parseInstance(o1).toPrintable());

        System.out.println("----------------------------");

        Object o2  = new Object();
        o2.hashCode();
        System.out.println(ClassLayout.parseInstance(o2).toPrintable());


    }
}
