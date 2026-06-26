package com.gladysz.threads.homework;


public class AppRunnable {

    public static void main(String[] args) {
        createThread(1);
    }


    public static void createThread(int num) {

        Thread thread = new Thread(() -> {
            System.out.println("Hello from Thread number " + num);

            if (num != 50) {
                createThread(num + 1);
            }
        });

        thread.start();
    }
}
