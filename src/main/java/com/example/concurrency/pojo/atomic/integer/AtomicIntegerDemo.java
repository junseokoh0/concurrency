package com.example.concurrency.pojo.atomic.integer;

public class AtomicIntegerDemo {

    public static void main(String[] args) {
        System.out.println(">>>>> runtime availableProcessors :: " + Runtime.getRuntime().availableProcessors());
        final Counter counter = new Counter();
        final Thread t1 = new Thread(counter, "t1");
        final Thread t2 = new Thread(counter, "t2");
        t1.start();
        t2.start();
        System.out.println(">>>>> counter.count :: " +  counter.getCount());
    }
}


class Counter implements Runnable {
    private int count = 0;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 10;


    @Override
    public void run() {
        for (int i = START_INDEX; i < END_INDEX; i++) count++;
    }

    public int getCount() {
        return count;
    }
}