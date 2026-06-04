package com.gladysz.multi.sum;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        int[] anArray = new int[1000];
        Arrays.fill(anArray, 1);

        Reducer reducer = new Reducer();

        PartialCalc p1 = new PartialCalc(reducer, anArray, 0, 500);
        PartialCalc p2 = new PartialCalc(reducer, anArray, 500, anArray.length);

        p1.start();
        p2.start();

        p1.join();
        p2.join();

        System.out.println(reducer.getCounter());
    }
}
