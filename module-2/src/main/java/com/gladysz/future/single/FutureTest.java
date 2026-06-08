package com.gladysz.future.single;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.gladysz.future.util.SleepUtil.sleep;


public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final Processor processor = new Processor();
        final Future<Integer> futureResult = processor.process(5);

        while(!futureResult.isDone()) {
            System.out.println("Doing something else");
            sleep(1);
        }

        final Integer result = futureResult.get();
        System.out.println("The result is: " + result);

        processor.shutdown();
    }
}
