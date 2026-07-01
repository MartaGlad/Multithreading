package com.gladysz.multi.exchanger.book;

import java.util.Random;
import java.util.concurrent.Exchanger;


public class BookProducer implements Runnable {

    private final Exchanger<Book> exchanger;


    public BookProducer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this, "BookProducer").start();
    }


    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("Title number " + rand.nextInt(1000),
                    "Author number " + rand.nextInt(1000));
            try {
                exchanger.exchange(book);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
