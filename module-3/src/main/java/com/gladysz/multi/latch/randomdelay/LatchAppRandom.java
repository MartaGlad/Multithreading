package com.gladysz.multi.latch.randomdelay;

import java.util.concurrent.CountDownLatch;


public class LatchAppRandom {

    public static void main(String[] args) {

        final int numberOfThreads = 5;

        CountDownLatch theLatch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new RandomTask("Worker-"+(i+1), theLatch)).start();
        }

        try {
            theLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("The latch has been closed");
    }
}
