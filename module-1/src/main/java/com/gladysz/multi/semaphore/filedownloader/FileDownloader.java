package com.gladysz.multi.semaphore.filedownloader;

import java.util.Random;
import java.util.concurrent.Semaphore;


public class FileDownloader implements Runnable {

    private static int counter;
    private static final Semaphore semaphore = new Semaphore(10);

    @Override
    public void run() {

        try {
           semaphore.acquire();
           download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }


    private void download() throws InterruptedException {

        Random random = new Random();

        synchronized (FileDownloader.class) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " stared download. " +
                    "Active downloads: " + counter);
        }
        Thread.sleep(random.nextInt(100));

        synchronized (FileDownloader.class) {
            counter--;

            System.out.println(Thread.currentThread().getName() + " finished download. " +
                    "Active downloads: " + counter);
        }
    }
}


