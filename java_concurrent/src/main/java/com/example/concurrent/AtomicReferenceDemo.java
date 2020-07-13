package com.example.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:38 on 2020/4/27
 * @version V0.1
 * @classNmae AtomicReferenceDemo
 */
public class AtomicReferenceDemo {


    public static AtomicReference<User> atomicUserRef = new
            AtomicReference<User>();
    public static void main(String[] args) {
        User user = new User("conan",15);
        User user_1 = new User("conan",15);
        atomicUserRef.set(user);
        User updateUser = new User("Shinichi",17);

        int count =0;
        while (!atomicUserRef.compareAndSet(user_1, updateUser)){
            count++;
            if(count==10){
                user_1 =user;
            }
        }
        System.out.println("count = "+count);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
    }

    static class User {
        private String name;
        private int old;
        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }
        public String getName() {
            return name;
        }
        public int getOld() {
            return old;}
    }
}
