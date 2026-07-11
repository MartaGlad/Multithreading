package com.gladysz.multi.exchanger.book;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ThreadLocalRandom;


public class BookProducer implements Runnable {

    private final Exchanger<Book> exchanger;


    public BookProducer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this, "BookProducer").start();
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book("Title number " + ThreadLocalRandom.current().nextInt(1000),
                    "Author number " + ThreadLocalRandom.current().nextInt(1000));
            try {
                exchanger.exchange(book);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
