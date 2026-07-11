package com.gladysz.lock;

import java.util.concurrent.ThreadLocalRandom;

import static com.gladysz.future.util.SleepUtil.sleep;


public class RemovingWorker implements Runnable {

    private final String workerName;
    private final LockedWarehouse warehouse;

    public RemovingWorker(String workerName, LockedWarehouse warehouse) {
        this.workerName = workerName;
        this.warehouse = warehouse;
    }


    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {

            sleep(1);

            final int id = ThreadLocalRandom.current().nextInt(3);

            if (id == 0) {
                warehouse.remove(Product.BOOK, workerName);
            } else if (id == 1) {
                warehouse.remove(Product.ELECTRONICS, workerName);
            } else {
                warehouse.remove(Product.TOYS, workerName);
            }
        }
    }
}