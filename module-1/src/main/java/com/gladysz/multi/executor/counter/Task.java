package com.gladysz.multi.executor.counter;

import java.util.concurrent.ThreadLocalRandom;

public class Task implements Runnable {

    private static int counter;


    @Override
    public void run() {

        taskBody();
    }


    private void taskBody() {

        int delay = ThreadLocalRandom.current().nextInt(100);

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        synchronized (Task.class) {
            counter++;
            System.out.println(Thread.currentThread().getName() + ", finished, counter = " + counter);
        }
    }
}
