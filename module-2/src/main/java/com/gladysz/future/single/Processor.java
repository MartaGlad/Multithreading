package com.gladysz.future.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.gladysz.future.util.SleepUtil.sleep;

public class Processor {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> process(int x) {

        return executor.submit(() -> {
            System.out.println("Processor started processing");
            sleep(5);
            System.out.println("Processor ended processing");
            return x * 1000;
        });
    }


    public void shutdown() {
        executor.shutdown();
    }
}
