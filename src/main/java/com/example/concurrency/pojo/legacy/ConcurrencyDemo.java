package com.example.concurrency.pojo.legacy;

import org.springframework.util.StopWatch;

public class ConcurrencyDemo {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        Runnable r = new DemoThread01();
        stopWatch.start();
        int i = 0;
        while (i < 1000) {
            i++;
            new Thread(r).start();
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}


class DemoThread01 implements Runnable {

    @Override
    public void run() {
        int i = 0;

        synchronized (this) {
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i--;
        }

        System.out.println(i);
//        System.out.println(this.getClass().getSimpleName() + Thread.currentThread().getName());
//        System.out.println(i + Thread.currentThread().getName());
    }
}


class DemoThread02 implements Runnable {

    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName());
    }
}
