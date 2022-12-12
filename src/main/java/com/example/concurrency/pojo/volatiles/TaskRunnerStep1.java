package com.example.concurrency.pojo.volatiles;

public class TaskRunnerStep1 {

    private static int number;
    private static boolean ready;

    /**
     * 해당 코드에서 사람들은 짧은 지연 후 42를 인쇄할 것이라 생각한다.
     * 하지만 실제는 지연이 훨씬 더 길 수 있고, 영원히 멈추거나 0을 인쇄할 수도 있다.
     *
     * 즉, 기본 스레드가 숫자와 준비된 변수를 업데이트 할 때 리더 스레드가 무엇을 볼 수 있는지에 대한 보장은 없다.
     * 즉, 리더 스레드는 업데이트 된 값을 바로 볼 수 있거나 약간의 지연이 있거나 전혀 볼 수 없다.
     */
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
