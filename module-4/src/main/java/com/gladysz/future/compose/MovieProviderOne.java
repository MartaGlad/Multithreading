package com.gladysz.future.compose;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MovieProviderOne {

    public CompletableFuture<List<Movie>> provideMovies() {

        System.out.println("Providing first movie list");

        return CompletableFuture.supplyAsync(() -> List.of(
                new Movie(5L, "Child's Play",  "Tom Holland"),
                new Movie(10L, "Scream", "Wes Craven"),
                new Movie(3L, "A Nightmare on Elm Street", "Wes Craven"),
                new Movie(6L, "Pet Sematary", "Mary Lambert")
        ));
    }
}
