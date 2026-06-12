package com.gladysz.multi.parallel.book;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private Books() {}

    public static List<Book> randomBooks (int number) {
        List<Book> books = new ArrayList<>();

        for (int n = 0; n < number; n++) {
            books.add(new Book("Title number " + n, "Author number " + n, n));
        }
        return books;
    }
}
