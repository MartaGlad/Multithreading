package com.gladysz.multi.exchanger.book;

import java.util.concurrent.Exchanger;


public class BookExchangerApp {

    public static void main(String[] args) {

        Exchanger<Book> exchanger = new Exchanger<>();

        new BookConsumer(exchanger);
        new BookProducer(exchanger);
    }
}

