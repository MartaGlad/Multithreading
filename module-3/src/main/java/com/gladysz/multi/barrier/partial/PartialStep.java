package com.gladysz.multi.barrier.partial;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class PartialStep implements Runnable {

    private final CyclicBarrier barrier;
    private final int number;


    public PartialStep(CyclicBarrier barrier, int number) {
        this.barrier = barrier;
        this.number = number;
    }


    @Override
    public void run() {
        System.out.println("Thread number " + number + " has been launched");
        try {//wątek zatrzymuje się i czeka, aż łącznie 5 wątków dotrze do tej samej bariery
            barrier.await();
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
