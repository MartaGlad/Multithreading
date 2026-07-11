package com.gladysz.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;

public class Producer extends Thread {

    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        int counter = 0;
        try {
            while (counter < 3) {
                buffer.add();
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                counter++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
