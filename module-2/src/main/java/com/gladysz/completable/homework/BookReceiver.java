package com.gladysz.completable.homework;

import java.util.concurrent.CompletableFuture;

import static com.gladysz.future.util.SleepUtil.sleep;

public class BookReceiver {

    public CompletableFuture<Book> receive() {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Waiting for book...");
            sleep(5);

            return new Book("Title", "Author", 1999);
        });
    }
}






