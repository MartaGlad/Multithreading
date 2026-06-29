package com.gladysz.readerswriters;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Database {

    private final List<Customer> customers = new LinkedList<>();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();


    public void insert(Customer customer) {
        writeLock.lock();
        try {
            customers.add(customer);
            System.out.println("Added: " + customer);
        }
        finally {
            writeLock.unlock();
        }
    }


    public List<Customer> select() {
        readLock.lock();
        try {
            System.out.println("Selected: " + customers.size() + " customers");
            return new ArrayList<>(customers);
        }
        finally {
            readLock.unlock();
        }
    }
}


