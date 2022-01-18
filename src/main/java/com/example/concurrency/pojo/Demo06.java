package com.example.concurrency.pojo;

import javax.swing.*;

class Demo06 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 : " + input + " 입니다.");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}

class Demo07 {
    public static void main(String[] args) {
        Demo07_01 th = new Demo07_01();
        th.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 : " + input + " 입니다.");
    }

    public static class Demo07_01 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }
        }
    }
}
