package com.gladysz.multi.semaphore.dbmanager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(50);

        for (int n = 0; n < 1000; n++) {
            executor.submit(new DbManager());
        }

        executor.shutdown();

        try {
            boolean finished = executor.awaitTermination(1, TimeUnit.MINUTES);

            if (finished) {
                System.out.println("All database connection tasks finished");
            }
            else  {
                System.out.println("Timeout: not all database connection tasks finished");
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
