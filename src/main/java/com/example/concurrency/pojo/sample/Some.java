package com.example.concurrency.pojo.sample;

import java.util.concurrent.atomic.AtomicInteger;

public class Some {
    private final AtomicInteger index = new AtomicInteger(0);
    private volatile int indexInt = 0;

    public synchronized void addIndex() {

//        final String threadName = "[" + Thread.currentThread().getName() + "]";
//        System.out.println(threadName + "addIndex() - index : " +  getIndex());
//        System.out.println(threadName + "addIndex() - indexInt : " + getIndexInt());

        try {
            Thread.sleep(1);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        this.index.addAndGet(1);
        this.indexInt += 1;
    }

    public int getIndex() {
        return this.index.get();
    }
    public int getIndexInt() {
        return this.indexInt;
    }
}
