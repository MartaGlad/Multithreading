package com.gladysz.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer extends Thread {

    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        int counter = 0;
        try {
            while (counter < 3) {
                buffer.get();
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                counter++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
