package com.gladysz.multi.barrier.sum;

import java.util.concurrent.CyclicBarrier;


public class BarrierAppSum {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(5, new FinalStepRace());

        for (int n = 0; n < 5; n++) {
            launchTheThread(barrier, n);
        }
    }


    private static void launchTheThread(CyclicBarrier barrier, int number) {

        new SumRace(barrier, number);
    }
}
