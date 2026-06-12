package com.gladysz.multi.parallel.country;

import java.util.ArrayList;
import java.util.List;

public class Countries {

    private Countries() {}

    public static List<Country> getCountries() {

        List<Country> countries = new ArrayList<>();

        countries.add(new Country("India", 1438000000L));
        countries.add(new Country("China", 1410000000L));
        countries.add(new Country("United States", 339000000L));
        countries.add(new Country("Indonesia", 277000000L));
        countries.add(new Country("Pakistan", 240000000L));
        countries.add(new Country("Nigeria", 223000000L));
        countries.add(new Country("Brazil", 203000000L));
        countries.add(new Country("Bangladesh", 173000000L));
        countries.add(new Country("Russia", 144000000L));
        countries.add(new Country("Mexico", 129000000L));
        countries.add(new Country("Japan", 123000000L));
        countries.add(new Country("Poland", 38000000L));

        return countries;
    }
}
