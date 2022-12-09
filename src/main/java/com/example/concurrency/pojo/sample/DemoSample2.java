package com.example.concurrency.pojo.sample;

public class DemoSample2 {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("r");
            }
        };

        Runnable r2 = () -> System.out.println("r2");


        new Thread(r).start();
        new Thread(r2).start();
        new Thread(() -> System.out.println("r3")).start();
        new Thread(new ThreadOne()).start();

        new ThreadTwo().start();
    }

    public static class ThreadOne implements Runnable {
        @Override
        public void run() {
            System.out.println(this.getClass().getSimpleName());
        }
    }

    public static class ThreadTwo extends Thread {
        @Override
        public void run() {
            System.out.println("thread Two running");
        }
    }

}
