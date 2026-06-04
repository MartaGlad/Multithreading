package com.gladysz.multi.simple;

public class Counter extends Thread {

    @Override
    public void run() {

        for(int n = 0; n < 20; n++) {

            //System.out.println("Object " + hashCode() + ", current value: " + n);
            System.out.println("Thread " + Thread.currentThread().threadId() + ", current value: " + n);
        }
    }
}
