package com.gladysz.multi.barrier.partial;

import java.util.concurrent.CyclicBarrier;


public class BarrierApp {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(5, new FinalStep());
        //5 - dopóki 5 wątków nie wywoła barrier.await(), żaden z nich nie przejdzie dalej.
        //new FinalStep() - akcja wykonywana raz, gdy ostatni z 5 wątków dotrze do bariery.


        //uruchomienie 5 wątków, utworzenie 5 obiektów PartialStep
        for (int n = 0; n < 5; n++)
            launchTheThread(barrier, n);
    }


    private static void launchTheThread(CyclicBarrier barrier, int number) {

        new PartialStep(barrier, number);
    }
}

