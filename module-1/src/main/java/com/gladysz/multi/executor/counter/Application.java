package com.gladysz.multi.executor.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {

        int cores = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(cores);

        for (int n = 0; n < 1000; n++) {
            executor.submit(new Task());
        }
        executor.shutdown();
    }
}
