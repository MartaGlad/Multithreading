package com.gladysz.multi.latch.simple;

import java.util.concurrent.CountDownLatch;


public class LatchAppSimple {

    public static void main(String[] args) {

        CountDownLatch theLatch = new CountDownLatch(5);

        new ExampleTask(theLatch);

        try {
            theLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("The latch has been closed");
    }
}
