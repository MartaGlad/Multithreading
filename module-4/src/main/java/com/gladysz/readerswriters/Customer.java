package com.gladysz.readerswriters;

import java.util.UUID;

public class Customer {

    private final UUID id;
    private final String name;


    public Customer(UUID id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
