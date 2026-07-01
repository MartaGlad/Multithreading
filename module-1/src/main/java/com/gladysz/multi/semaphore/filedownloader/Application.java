package com.gladysz.multi.semaphore.filedownloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 500; i++) {
            executor.submit(new FileDownloader());
        }

        executor.shutdown();

        try {
            boolean finished = executor.awaitTermination(1, TimeUnit.MINUTES);

            if (finished) {
                System.out.println("All files downloaded");
            }
            else  {
                System.out.println("Timeout: not all files were downloaded.");
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
