package com.gladysz.multi.barrier.partial;

public class FinalStep implements Runnable {

    @Override
    public void run() {

        System.out.println("Reached the final step");
    }
}
