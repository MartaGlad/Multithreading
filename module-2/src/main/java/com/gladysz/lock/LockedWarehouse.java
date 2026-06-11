package com.gladysz.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.*;

import static com.gladysz.future.util.SleepUtil.sleep;


public class LockedWarehouse {

    private final Map<Product, Integer> products = new HashMap<>();
    private final StampedLock lock = new StampedLock();


    public void add(Product product, String by) {

        System.out.println("I'm " + by + " and want to add " + product);

        final long stamp = lock.writeLock();

        try {
            sleep(2);
            products.merge(product, 1, Integer::sum);
            System.out.println("Product " + product + " added by " + by
                    + ". Number of products in warehouse: " + countProducts());
        } finally {
            lock.unlockWrite(stamp);
        }
    }


    public void remove(Product product, String by) {

        System.out.println("I'm " + by + " and want to remove " + product);

        final long stamp = lock.writeLock();

        try {
            sleep(1);
            final Integer quantity = products.get(product);
            if (quantity == null || quantity == 0) {
                System.out.println("Product " + product + " not available. Cannot be removed.");
                return;
            }
            if (quantity == 1) {
                products.remove(product);
            }
            else {
                products.put(product, quantity - 1);
            }
            System.out.println("Product " + product + " removed by " + by
                    + ". Number of products in warehouse: " + countProducts());

        } finally {
            lock.unlockWrite(stamp);
        }
    }


    private int countProducts() {

        return products.values().stream().reduce(0, Integer::sum);
    }


    public void showProducts(String inventoryWorkerName) {

        System.out.println("I'm " + inventoryWorkerName + " and want to check INVENTORY.");

        final long stamp = lock.readLock();

        try {
            products.forEach((k, v) ->
                    System.out.println(
                            "[" + inventoryWorkerName + "]" + "Product: " + k + " quantity: " + v));
        } finally {
            lock.unlockRead(stamp);
        }
    }
}
