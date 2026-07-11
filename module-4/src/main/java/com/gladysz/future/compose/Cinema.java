package com.gladysz.future.compose;


import java.util.*;


public class Cinema {

    private static final MovieProviderOne movieProviderOne = new MovieProviderOne();
    private static final MovieProviderTwo movieProviderTwo = new MovieProviderTwo();


    public static void main(String[] args) {

        movieProviderOne.provideMovies().thenCompose(firstMovies ->
            movieProviderTwo.provideMovies().thenApply(secondMovies -> {

                List<Movie> mergedMovies = new ArrayList<>(firstMovies);
                mergedMovies.addAll(secondMovies);

                Set<Movie> uniqueMovies = new LinkedHashSet<>(mergedMovies);

                return new ArrayList<>(uniqueMovies);
            })
        ).thenAccept(movies -> movies.forEach(System.out::println)).join();
    }
}




