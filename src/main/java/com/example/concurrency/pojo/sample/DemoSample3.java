package com.example.concurrency.pojo.sample;

/**
 * 동시성 문제 발생.
 * 어떻게 처리할 것인가 더 분석하고, 정확하게.
 */
public class DemoSample3 {

    private static final Some some = new Some();

    public static void main(String[] args) {

        int i = 0;
        while (i < 10) {
            i++;
            System.out.println(i);
            new Thread(new FirstThread()).start();
            new SecondThread().start();
            new Thread(some::addIndex).start();
        }

        System.out.println("some.getIndex : " + some.getIndex());
        System.out.println("some.getIndexInt : " + some.getIndexInt());

    }

    public static class FirstThread implements Runnable {

        @Override
        public void run() {
            some.addIndex();
        }
    }

    public static class SecondThread extends Thread {
        @Override
        public void run() {
            some.addIndex();
        }
    }

}
