package com.gladysz.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

import static com.gladysz.future.util.SleepUtil.sleep;

public class CombineTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        final CompletableFuture<Integer> calculationFuture1 = CompletableFuture.supplyAsync(() -> {

            System.out.println("Calculation 1 in process...");
            sleep(4);
            final int result = ThreadLocalRandom.current().nextInt(1000);
            System.out.println("The result of calculation 1 is " + result);
            return result;
        });


        final CompletableFuture<Integer> calculationFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculation 2 in process...");
            sleep(2);
            final int result = ThreadLocalRandom.current().nextInt(10);
            System.out.println("The result of calculation 2 is " + result);
            return result;
        });

        calculationFuture1
                .thenCombine(calculationFuture2, (result1, result2) -> result1 * result2)
                .thenAccept(result -> System.out.println("The final result is " + result))
                .get();
    }
}
