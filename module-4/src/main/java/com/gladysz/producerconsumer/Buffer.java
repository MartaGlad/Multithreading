package com.gladysz.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private final Queue<Integer> products = new LinkedList<>();

    private final Lock lock = new ReentrantLock();

    private final Condition bufferNotEmpty = lock.newCondition();
    private final Condition bufferNotFull = lock.newCondition();

    private static final int CAPACITY = 5;


    public void add() throws InterruptedException {
        lock.lock(); //przejęcie blokady
        try {
            while (products.size() == CAPACITY) {
                System.out.println("[PRODUCER] Waiting - buffer is full");
                bufferNotFull.await(); //czeka aż bufor nie bedzie pełny, await tymczasowo zwalnia lock
            }

            final Random theRandom = new Random();
            int product = theRandom.nextInt();
            products.offer(product);
            System.out.println("[PRODUCER] Added to buffer " + product);

            System.out.println("[SIGNAL] Buffer is not empty from now");
            bufferNotEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }


    public void get() throws InterruptedException {
        lock.lock();
        try {
            while (products.isEmpty()) {
                System.out.println("[CONSUMER] Waiting - no products in buffer");
                bufferNotEmpty.await(); //czeka na sygnał, że bufor nie jest pusty i może cos pobrać
            }

            Integer product = products.poll();
            System.out.println("[CONSUMER] Consumed product: " + product);

            System.out.println("[SIGNAL] Buffer is not full from now");
            bufferNotFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
