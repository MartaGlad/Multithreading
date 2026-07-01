package com.gladysz.multi.semaphore.filedownloader;

import java.util.Random;
import java.util.concurrent.Semaphore;


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
            return;
        }
        finally {
            if (acquired) {
                semaphore.release();
            }
        }
    }


    private void download() throws InterruptedException {

        Random random = new Random();

        synchronized (FileDownloader.class) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " started download. " +
                    "Active downloads: " + counter);
        }

        Thread.sleep(random.nextInt(1000));

        synchronized (FileDownloader.class) {
            counter--;
            System.out.println(Thread.currentThread().getName() + " finished download. " +
                    "Active downloads: " + counter);
        }
    }
}


