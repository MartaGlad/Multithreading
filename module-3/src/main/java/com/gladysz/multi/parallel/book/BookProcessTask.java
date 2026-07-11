package com.gladysz.multi.parallel.book;

import java.util.List;
import java.util.concurrent.RecursiveTask;


public class BookProcessTask extends RecursiveTask<Long> {

    private final List<Book> books;


    BookProcessTask(List<Book> books) {

        this.books = books;
    }


    @Override
    protected Long compute() {

        if (books.size() <= 10) {
            return books
                    .stream()
                    .mapToLong(BookProcessTask::processBook)
                    .sum();
        } else {
            int middle = books.size() / 2;
            BookProcessTask left = new BookProcessTask(books.subList(0, middle));
            BookProcessTask right = new BookProcessTask(books.subList(middle, books.size()));

            left.fork();

            long rightResult = right.compute();
            long leftResult = left.join();

            return leftResult + rightResult;
        }
    }


    private static long processBook (Book b) {

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return (long) (b.getYear() * 2L + (double) b.getYear() / 2 + Math.floor(
                Math.sqrt(b.getYear())));
    }
}
