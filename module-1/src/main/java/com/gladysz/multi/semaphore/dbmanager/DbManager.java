package com.gladysz.multi.semaphore.dbmanager;

import java.util.Random;
import java.util.concurrent.Semaphore;


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
           return;
        }
        finally {
            if (acquired) {
                semaphore.release();
            }
        }
    }


    private void connect() throws InterruptedException {

        Random random = new Random();

        synchronized (DbManager.class) {
            counter++;
            System.out.println("There is/are " + counter + " connections");
        }

        Thread.sleep(random.nextInt(100));

        synchronized (DbManager.class) {
            counter--;
        }
    }
}
