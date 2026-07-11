package com.gladysz.multi.semaphore.dbmanager;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;


public class DbManager implements Runnable {

    private static int counter;
    private static final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {

        boolean acquired = false;

        try {
            semaphore.acquire();
            acquired = true;

            connect();
        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        }
        finally {
            if (acquired) {
                semaphore.release();
            }
        }
    }


    private void connect() throws InterruptedException {

        synchronized (DbManager.class) {
            counter++;
            System.out.println("There is/are " + counter + " connections");
        }

        Thread.sleep(ThreadLocalRandom.current().nextInt(100));

        synchronized (DbManager.class) {
            counter--;
        }
    }
}
