package com.gladysz.producerconsumer;

public class ProducerConsumerApp {

    public static void main(String[] args) {
        final Buffer buffer = new Buffer();

        final Consumer consumer = new Consumer(buffer);
        final Producer producer = new Producer(buffer);

        consumer.start();
        producer.start();
    }
}
