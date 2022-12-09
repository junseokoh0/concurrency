package com.example.concurrency.pojo.sample;

import java.util.concurrent.atomic.AtomicInteger;

public class Some {
    private final AtomicInteger index = new AtomicInteger(1);
    private volatile int indexInt = 0;

    public synchronized void addIndex() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        this.index.addAndGet(this.index.get());
        this.indexInt += 1;
    }

    public int getIndex() {
        return this.index.get();
    }
    public int getIndexInt() {
        return this.indexInt;
    }
}
