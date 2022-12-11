package com.example.concurrency.pojo.atomic.integer;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(">>>>> runtime availableProcessors :: " + Runtime.getRuntime().availableProcessors());
//        final Counter counter = new Counter();
//        final AtomicCounter counter = new AtomicCounter();
        final ThreadLocalCounter counter = new ThreadLocalCounter();
        final Thread t1 = new Thread(counter, "t1");
        final Thread t2 = new Thread(counter, "t2");
        t1.start();
        t2.start();
    }
}

class AtomicCounter implements Runnable {
    private final AtomicInteger count = new AtomicInteger();
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 10;


    @SneakyThrows
    @Override
    public void run() {
        for (int i = START_INDEX; i < END_INDEX; i++) {
            Thread.sleep(10);
//            System.out.println(">>>>> Thread [" + Thread.currentThread().getName() + "] current count :: " + getCount());
            count.addAndGet(1);
        }
        printThreadWithCount(Thread.currentThread());
    }

    private void printThreadWithCount(Thread thread) {
        System.out.println(">>>>> " + thread.getName() + " - count : " + getCount());
    }

    public int getCount() {
        return count.get();
    }
}

class ThreadLocalCounter implements Runnable {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 10;

    private ThreadLocal<Integer> count = new ThreadLocal<>();

    @SneakyThrows
    @Override
    public void run() {

        if (START_INDEX == 0) count.set(0);

        for (int i = START_INDEX; i < END_INDEX; i++) {
            count.set(count.get() + 1);
        }
        printThreadWithCount(Thread.currentThread());
    }

    private void printThreadWithCount(Thread thread) {
        System.out.println(">>>>> " + thread.getName() + " - count : " + getCount());
    }

    public int getCount() {
        return count.get();
    }
}

class Counter implements Runnable {
    private int count = 0;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 10;


    @SneakyThrows
    @Override
    public void run() {
        for (int i = START_INDEX; i < END_INDEX; i++) {
            Thread.sleep(10);
//            System.out.println(">>>>> Thread [" + Thread.currentThread().getName() + "] current count :: " + getCount());
            count++;
        }
        printThreadWithCount(Thread.currentThread());
    }

    private void printThreadWithCount(Thread thread) {
        System.out.println(">>>>> " + thread.getName() + " - count : " + getCount());
    }

    public int getCount() {
        return count;
    }
}