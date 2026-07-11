package com.gladysz.lock;

import java.util.concurrent.ThreadLocalRandom;

import static com.gladysz.future.util.SleepUtil.sleep;


public class Worker implements Runnable {

    private final String workerName;
    private final LockedWarehouse warehouse;

    public Worker(String workerName, LockedWarehouse warehouse) {
        this.workerName = workerName;
        this.warehouse = warehouse;
    }


    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {

            sleep(1);

            final int id = ThreadLocalRandom.current().nextInt(3);

            if (id == 0) {
                warehouse.add(Product.BOOK, workerName);
            } else if (id == 1) {
                warehouse.add(Product.ELECTRONICS, workerName);
            } else {
                warehouse.add(Product.TOYS, workerName);
            }
        }
    }
}
