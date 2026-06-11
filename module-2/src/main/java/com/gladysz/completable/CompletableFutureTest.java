package com.gladysz.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.gladysz.future.util.SleepUtil.sleep;


public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final MessageReceiver messageReceiver = new MessageReceiver();

        final CompletableFuture<Void> futureMessage = messageReceiver.receive()
                .thenApply(String::toUpperCase)
                .thenApply(x -> {
                    throw new RuntimeException("Cannot process message");
                })
                .exceptionally(exception -> {
                    System.err.println("Exception occurred:  " + exception.getMessage());
                    return "ERROR";
                })
                .thenAccept(message -> System.out.println("Message is: "  + message));

        sleep(1);

        System.out.println("Doing something else");

        futureMessage.get();
    }
}
