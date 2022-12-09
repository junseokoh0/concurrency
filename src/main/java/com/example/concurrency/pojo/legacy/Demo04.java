package com.example.concurrency.pojo.legacy;

public class Demo04 {

    static long startTime = 0;

    public static void main(String[] args) {

        Demo04_01 th1 = new Demo04_01();
        th1.start();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) System.out.printf("%s", "-");
        System.out.println("소요시간1:" + (System.currentTimeMillis() - startTime));
    }

}

class Demo04_01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) System.out.printf("%s", "|");
        System.out.println("소요시간2:" + (System.currentTimeMillis() - Demo04.startTime));
    }
}
