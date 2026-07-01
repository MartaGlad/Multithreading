package com.gladysz.multi.executor.arraymultiplication;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

    private static final int SIZE = 10;


    public static void main(String[] args) {

        int[] anArray1 = new int[SIZE];
        int[] anArray2 = new int[SIZE];
        long[] resultArray = new long [SIZE];

        if (anArray1.length == 0) {
            System.out.println("Arrays are empty.");
            return;
        }

        Arrays.fill(anArray1, 2);
        Arrays.fill(anArray2, 5);

        int cores = Runtime.getRuntime().availableProcessors();
        int threads = Math.min(cores, anArray1.length);

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        int baseChunkSize = anArray1.length / threads;

        for (int n = 0; n < threads; n++) {

            int startIndex = n * baseChunkSize;
            int endIndex;

            if (n == threads - 1) {
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
