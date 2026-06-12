package com.gladysz.multi.parallel.country;

public final class Country {

    private final String name;
    private final long peopleQuantity;

    public Country(String name, long peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }


    public String getName() {

        return name;
    }


    public long getPeopleQuantity() {

        return peopleQuantity;
    }


    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", peopleQuantity=" + peopleQuantity +
                '}';
    }
}
