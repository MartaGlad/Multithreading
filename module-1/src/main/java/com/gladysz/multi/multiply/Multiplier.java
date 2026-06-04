package com.gladysz.multi.multiply;

public class Multiplier {

    private final int value;


    public Multiplier (int value) {

        this.value = value;
    }


    public int multiply (int number) {

        return value * number;
    }


    public int getValue() {

        return value;
    }
}
