package com.gladysz.multi.exchanger.book;

import java.util.concurrent.Exchanger;


public class BookConsumer implements Runnable {

    private final Exchanger<Book> exchanger;

    public BookConsumer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this, "BookConsumer").start();
    }


    @Override
    public void run() {
        for (int n = 0; n < 10; n++) {
            try {
                Book book = exchanger.exchange(null);
                System.out.println(Thread.currentThread().getName() + ":" + book);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

