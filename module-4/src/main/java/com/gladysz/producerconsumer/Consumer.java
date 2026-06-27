package com.gladysz.producerconsumer;

import java.util.Random;

public class Consumer extends Thread {

    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        int counter = 0;
        final Random random = new Random();
        try {
            while (counter < 3) {
                buffer.get();
                Thread.sleep(random.nextInt(1000));
                counter++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
