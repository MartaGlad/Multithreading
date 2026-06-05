package com.gladysz.multi.executor.arraymultiplication;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

    private static final int SIZE = 10;

    public static void main(String[] args) {

        int[] anArray1 = new int[SIZE];
        Arrays.fill(anArray1, 2);

        int[] anArray2 = new int[SIZE];
        Arrays.fill(anArray2, 5);

        long[] resultArray = new long [SIZE];

        int cores = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(cores);

        int baseChunkSize = anArray1.length / cores;

        for (int n = 0; n < cores; n++) {

            int startIndex = n * baseChunkSize;
            int endIndex;

            if (n == cores - 1) {
                endIndex = anArray1.length;
            }
            else {
                endIndex = (n + 1) * baseChunkSize;
            }

            executor.submit(
                    new Multiplication(anArray1, anArray2, resultArray, startIndex, endIndex));
        }
        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(resultArray));
    }
}
