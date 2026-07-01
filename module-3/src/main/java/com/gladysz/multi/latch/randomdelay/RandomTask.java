package com.gladysz.multi.latch.randomdelay;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;


public class RandomTask implements Runnable {

    private final String taskName;
    private final CountDownLatch theLatch;


    public RandomTask(String taskName, CountDownLatch theLatch) {
        this.taskName = taskName;
        this.theLatch = theLatch;
    }


    @Override
    public void run() {

        int ms = ThreadLocalRandom.current().nextInt(500, 2001);
        System.out.println(taskName + " will work at " + ms + " ms");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(taskName + " finished working");
            theLatch.countDown();
        }
    }
}

