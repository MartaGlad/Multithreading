package com.gladysz.multi.parallel.country;

import java.util.List;
import java.util.concurrent.ForkJoinPool;



public class ForkJoinCountryApp {

    public static void main(String[] args) {
        List<Country> countries = Countries.getCountries();

        ForkJoinPool thePool = new ForkJoinPool();

        Long result = thePool.invoke(new CountryProcessTask(countries));
        System.out.println("World population is: " + result);
    }
}

