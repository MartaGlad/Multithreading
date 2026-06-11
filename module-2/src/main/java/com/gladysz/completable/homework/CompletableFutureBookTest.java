package com.gladysz.completable.homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.gladysz.future.util.SleepUtil.sleep;


public class CompletableFutureBookTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final BookReceiver bookReceiver = new BookReceiver();

        final CompletableFuture<Void> bookFuture = bookReceiver.receive()
                .thenApply(book -> {
                    book.setSignature("L12345677");

                    return book;
                })
                .thenAccept(book -> System.out.println(book.getTitle() + " "
                        + book.getAuthor() + " " + book.getYear() + " " + book.getSignature()));

        sleep(1);
        System.out.println("Doing something else");
        bookFuture.get();
    }
}
