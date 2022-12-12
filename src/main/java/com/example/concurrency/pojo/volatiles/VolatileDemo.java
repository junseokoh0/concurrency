package com.example.concurrency.pojo.volatiles;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO volatile 변수 C에 대한 정확한 이해와 설명 필요
 */
public class VolatileDemo {

    @Getter @Setter
    public static class Shared {
        private int a;
        private int b;
        private volatile int c;

        public void display() {
            System.out.println(getC());
            System.out.println(getB());
            System.out.println(getA());
        }

        public void setSharedField(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            setA(1);
            setB(2);
            setC(3);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Shared shared = new Shared();

        Thread thread1 = new Thread(shared::setSharedField);
        Thread thread2 = new Thread(shared::display);
        thread1.start();
        thread2.start();
    }




}



