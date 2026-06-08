package com.gladysz.future.paralell;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.gladysz.future.util.SleepUtil.sleep;


public class ParallelProcessor {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public Future<String> process(String text, int seconds) {

        return executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            sleep(seconds);
            System.out.println(Thread.currentThread().getName() + " ended");
            return text.toUpperCase();
        });
    }


    public void shutdown() {
        executor.shutdown();
    }
}
