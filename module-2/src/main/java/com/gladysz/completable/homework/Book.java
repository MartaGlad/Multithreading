package com.gladysz.completable.homework;

public class Book {

    private final String title;
    private final String author;
    private final int year;
    private String signature;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.signature = null;
    }


    public String getTitle() {

        return title;
    }


    public String getAuthor() {

        return author;
    }


    public int getYear() {

        return year;
    }


    public String getSignature() {

        return signature;
    }


    public void setSignature(String signature) {

        this.signature = signature;
    }
}
