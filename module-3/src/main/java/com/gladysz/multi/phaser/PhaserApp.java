package com.gladysz.multi.phaser;

import java.util.concurrent.Phaser;

public class PhaserApp {

    public static void main(String[] args) {
        //Tworzony jest Phaser z jednym początkowym uczestnikiem, czyli wątkiem głównym - main.
        Phaser phaser = new Phaser(1);

        int phaseNum = phaser.getPhase();

        new PhasedTask(phaser,0);
        new PhasedTask(phaser,1);
        new PhasedTask(phaser,2);
        new PhasedTask(phaser,3);
        new PhasedTask(phaser,4);

        System.out.println("Phase " + phaseNum + " - begin");
        phaser.arriveAndAwaitAdvance();

        phaseNum = phaser.getPhase();
        System.out.println("Phase " + phaseNum + " - reached");
        phaser.arriveAndAwaitAdvance();

        phaseNum = phaser.getPhase();
        System.out.println("Phase " + phaseNum + " - reached");
        phaser.arriveAndAwaitAdvance();

        phaseNum = phaser.getPhase();
        System.out.println("Phase " + phaseNum + " - reached");

        phaser.arriveAndDeregister(); //main się wyrejestrowuje


        while (!phaser.isTerminated()) {
            //do nothing, just wait
        } //Wątek główny czeka, aż Phaser zostanie zakończony, co nastąpi
          //gdy liczba zarejestrowanych uczestników spadnie do zera.

        System.out.println("Work is finished");
    }
}
