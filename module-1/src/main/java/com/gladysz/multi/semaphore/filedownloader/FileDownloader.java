package com.gladysz.multi.semaphore.filedownloader;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;


public class FileDownloader implements Runnable {

    private static int counter;
    private static final Semaphore semaphore = new Semaphore(10);


    @Override
    public void run() {

        boolean acquired = false;

        try {
           semaphore.acquire();
           acquired = true;

           download();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            if (acquired) {
                semaphore.release();
            }
        }
    }


    private void download() throws InterruptedException {

        synchronized (FileDownloader.class) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " started download. " +
                    "Active downloads: " + counter);
        }

        Thread.sleep(ThreadLocalRandom.current().nextInt(1000));

        synchronized (FileDownloader.class) {
            counter--;
            System.out.println(Thread.currentThread().getName() + " finished download. " +
                    "Active downloads: " + counter);
        }
    }
}


