package com.gladysz.lock;

import java.util.concurrent.ThreadLocalRandom;

import static com.gladysz.future.util.SleepUtil.sleep;


public class InventoryWorker implements Runnable {

    private final String workerName;
    private final LockedWarehouse warehouse;


    public InventoryWorker(String workerName, LockedWarehouse warehouse) {
        this.workerName = workerName;
        this.warehouse = warehouse;
    }


    public void run() {

        for (int i = 0; i < 5; i++) {

            sleep(ThreadLocalRandom.current().nextInt(4));
            warehouse.showProducts(workerName);
        }
    }
}
