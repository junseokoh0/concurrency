package com.example.concurrency.pojo.volatiles;

public class VolatileTest {

    public static void main(String[] args) {
        final SharedObject sharedObject = new SharedObject();

        final Thread thread1 = new Thread(() -> {
            final long startTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) sharedObject.counter++;
            final long endTimeMillis = System.currentTimeMillis();
            System.out.println(">>>>> executeTimeMillis :: " + (endTimeMillis - startTimeMillis));
            System.out.println(":::::" + Thread.currentThread().getName() + " counter :: " + sharedObject.getCounter());
        });
//        final Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 100000000; i++) sharedObject.counter++;
//            System.out.println(":::::" + Thread.currentThread().getName() + " counter :: " + sharedObject.getCounter());
//        });

        thread1.start();
//        thread2.start();
        System.out.println(":::::" + Thread.currentThread().getName() + " counter :: " + sharedObject.getCounter());
    }
}

class SharedObject {
    public int counter = 0;


    public int getCounter() {
        return counter;
    }
}