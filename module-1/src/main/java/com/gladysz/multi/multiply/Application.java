package com.gladysz.multi.multiply;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        int[] anArray = new int[10];
        Arrays.fill(anArray, 2);

        Multiplier multiplier = new Multiplier(2);

        Thread t1 = new Thread (new PartialMultiply(multiplier, anArray, 0,5));
        Thread t2 = new Thread (new PartialMultiply(multiplier, anArray, 5,10));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(Arrays.toString(anArray));
    }
}

