package com.gladysz.future.compose;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MovieProviderTwo {

    public CompletableFuture<List<Movie>> provideMovies() {

        System.out.println("Providing second movie list");

        return CompletableFuture.supplyAsync(() -> List.of(
                new Movie(5L, "Child's Play",  "Tom Holland"),
                new Movie(10L, "Scream", "Wes Craven"),
                new Movie(8L, "The Silence of the Lambs", "Jonathan Demme"),
                new Movie(13L, "Strange Darling", "JT Mollner")
        ));
    }
}
