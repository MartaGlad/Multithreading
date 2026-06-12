package com.gladysz.multi.parallel.country;


import java.util.List;
import java.util.concurrent.RecursiveTask;


public class CountryProcessTask extends RecursiveTask<Long> {

    private final List<Country> countries;


    public CountryProcessTask(List<Country> countries) {
        this.countries = countries;
    }


    @Override
    protected Long compute() {

        if (countries.size() <= 2) {
            return countries
                    .stream()
                    .mapToLong(Country::getPeopleQuantity)
                    .sum();
        } else {
            int middle = countries.size() / 2;
            CountryProcessTask left = new CountryProcessTask(countries.subList(0, middle));
            CountryProcessTask right = new CountryProcessTask(countries.subList(middle, countries.size()));

            left.fork();

            long rightTaskResult = right.compute();
            long leftTaskResult = left.join();

            return leftTaskResult + rightTaskResult;
        }
    }
}

