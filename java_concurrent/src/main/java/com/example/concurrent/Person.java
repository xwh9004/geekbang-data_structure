package com.example.concurrent;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:43 on 2020/4/26
 * @version V0.1
 * @classNmae Entity
 */
public class Person {
    public int age;

    public Person(int age){
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return age;
    }
}
