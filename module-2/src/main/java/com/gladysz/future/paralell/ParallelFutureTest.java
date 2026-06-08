package com.gladysz.future.paralell;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.gladysz.future.util.SleepUtil.sleep;

public class ParallelFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ParallelProcessor processor = new ParallelProcessor();

        final Future<String> futureResult1 = processor.process("result1", 7);
        final Future<String> futureResult2 = processor.process("result2", 3);

        while(!futureResult1.isDone() || !futureResult2.isDone()) {
            System.out.println("Result1 is " + (futureResult1.isDone() ? "done" : "not done"));
            System.out.println("Result2 is " + (futureResult2.isDone() ? "done" : "not done"));
            sleep(1);
        }

        System.out.println("\nThe result1 is: " + futureResult1.get());
        System.out.println("The result2 is: " + futureResult2.get());

        processor.shutdown();
    }
}
