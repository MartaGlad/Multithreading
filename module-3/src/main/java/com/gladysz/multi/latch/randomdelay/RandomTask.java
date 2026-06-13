package com.gladysz.multi.latch.randomdelay;

import java.util.Random;
import java.util.concurrent.CountDownLatch;



public class RandomTask implements Runnable {

    private final String taskName;
    private final CountDownLatch theLatch;


    public RandomTask(String taskName, CountDownLatch theLatch) {
        this.taskName = taskName;
        this.theLatch = theLatch;
    }


    @Override
    public void run() {
        int ms = 500 + new Random().nextInt(1501);
        System.out.println(taskName + " will work at " + ms + " ms");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(taskName + " finished working");
            theLatch.countDown();
        }
    }
}

