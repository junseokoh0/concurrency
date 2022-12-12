package com.example.concurrency.pojo.volatiles;

public class TaskRunnerStep2 {

    private static volatile int number;
    private static boolean ready;

    private static class Reader extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        number = 42;
        ready = true;
    }
}
