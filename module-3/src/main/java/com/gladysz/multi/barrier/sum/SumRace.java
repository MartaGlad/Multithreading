package com.gladysz.multi.barrier.sum;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;


public class SumRace implements Runnable {

    private final CyclicBarrier barrier;
    private final int number;


    public SumRace(CyclicBarrier barrier, int number) {
        this.barrier = barrier;
        this.number = number;
    }


    @Override
    public void run() {

        int sumA = 1000;
        int sumB = 0;
        int counter = 0;

        while (sumA > sumB) {
            counter++;
            sumA += ThreadLocalRandom.current().nextInt(10);
            sumB += ThreadLocalRandom.current().nextInt(50);
            System.out.println("Thread nr: " + number + " | Counter: " + counter +
                    " | SumA: " + sumA + " | SumB: " + sumB);
        }

        try {
            barrier.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
