package com.gladysz.threads;

public class ThreadCreator extends Thread {

    private final int num;

    public ThreadCreator(int num) {
        this.num = num;
    }


    @Override
    public void run() {

        System.out.println("Hello from Thread number " + num);
        if (num != 50) {
            final Thread thread = new ThreadCreator(num + 1);
            thread.start();
        }
    }
}
