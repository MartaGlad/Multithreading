package com.gladysz.multi.phaser;

import java.util.concurrent.Phaser;


public class PhasedTask implements Runnable {

    private final Phaser phaser;
    private final int number;


    public PhasedTask(Phaser phaser, int number) {
        this.phaser = phaser;
        this.number = number;
        phaser.register();
        new Thread(this).start();
    }


    @Override
    public void run() {

        System.out.println("Process number " + number + " phase 0 entered");
        try {
            Thread.sleep(200);
        }  catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        phaser.arriveAndAwaitAdvance(); //skończył fazę 0
        //i jeżeli pozostałe wątki jeszcze nie skończyły fazy 0, czeka


        //Po zakończeniu fazy 0 wszystkie wątki przechodzą do fazy 1
        System.out.println("Process number " + number + " phase 1 entered");
        try {
            Thread.sleep(200);
        }  catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        phaser.arriveAndAwaitAdvance();


        System.out.println("Process number " + number + " phase 2 entered");
        try {
            Thread.sleep(200);
        }  catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        phaser.arriveAndAwaitAdvance();


        System.out.println("Process number " + number + " phase 3 entered");
        try {
            Thread.sleep(200);
        }  catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        phaser.arriveAndAwaitAdvance();


        System.out.println("Process number " + number + " finish reached");
        try {
            Thread.sleep(200);
        }  catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        phaser.arriveAndDeregister();
        //dotarł do końca i wypisujęe się z Phasera,
        //czyli ten wątek nie będzie już brał udziału w kolejnych fazach.

    }
}
