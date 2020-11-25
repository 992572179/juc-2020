package com.sk.thread.classlayout;

import com.sk.thread.entities.Person;
import org.openjdk.jol.info.ClassLayout;

public class ClassLayoutOfPerson {

    public static void main(String[] args) {
        Person person = new Person("zs",22);
//        System.out.println(person.IDENTITY);
        System.out.println(ClassLayout.parseInstance(person).toPrintable());

        synchronized (person) {
            System.out.println(ClassLayout.parseInstance(person).toPrintable());
        }

    }
}
