package com.sk.thread.classlayout;

import com.sk.thread.entities.Person;

public class ThreadLocalInsp {

    public static void main(String[] args) {

        ThreadLocal<Person> tl = new ThreadLocal();
        tl.set(new Person());
        tl.remove();

    }
}
