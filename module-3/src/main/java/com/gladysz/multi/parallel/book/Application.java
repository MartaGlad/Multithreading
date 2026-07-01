package com.gladysz.multi.parallel.book;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Book> books = Books.randomBooks(1000);

        long begin = System.nanoTime();
        long sum = books
                .stream()
                .mapToLong(Application::processData)
                .sum();
        long end = System.nanoTime();

        System.out.println("Processing 1k books with stream() has taken " + (end-begin) + " ns.");
        System.out.println("The sum is equal to " + sum);

        begin = System.nanoTime();
        sum = books
                .parallelStream()
                .mapToLong(Application::processData)
                .sum();
        end = System.nanoTime();

        System.out.println("Processing 1k books with parallelStream() has taken " + (end-begin) + " ns.");
        System.out.println("The sum is equal to " + sum);
    }


    private static long processData (Book b) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return (long) (b.getYear() * 2L + (double) b.getYear() / 2 + Math.floor(
                Math.sqrt(b.getYear())));
    }
}
