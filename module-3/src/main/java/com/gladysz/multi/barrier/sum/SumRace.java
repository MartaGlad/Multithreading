package com.gladysz.multi.barrier.sum;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class SumRace implements Runnable {

    private final CyclicBarrier barrier;
    private final int number;


    public SumRace(CyclicBarrier barrier, int number) {
        this.barrier = barrier;
        this.number = number;
        new Thread(this).start();
    }


    @Override
    public void run() {
        int sumA = 1000;
        int sumB = 0;
        int counter = 0;
        Random rand = new Random();

        while(sumA > sumB) {
            counter++;
            sumA += rand.nextInt(10);
            sumB += rand.nextInt(50);
            System.out.println("Thread nr: " + number + " | Counter: " + counter +
                    " | SumA: " + sumA + " | SumB: " + sumB);
        }

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
