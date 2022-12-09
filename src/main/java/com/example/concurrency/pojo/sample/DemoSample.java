package com.example.concurrency.pojo.sample;

public class DemoSample {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(10000);

        final int availableProcessors = Runtime.getRuntime().availableProcessors();

        int i = 0;

        while(i < 1000) {
            i++;
            System.out.println("[" + Thread.currentThread().getName() + "] start....");
            final Thread thread = getThread();
            thread.start();
        }

        System.out.println("availableProcessors : " + availableProcessors);
    }

    private static Thread getThread() {
        return new Thread(() -> {

            final String threadName = Thread.currentThread().getName();
            System.out.println("[" + threadName + "] start....");
            int j = 0;
            while(j < 10) {
                j++;
                runningThread(threadName);
            }
            System.out.println("[" + threadName + "] end....");
        });
    }

    private static void runningThread(String threadName) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("[" + threadName + "] running....");
    }
}
