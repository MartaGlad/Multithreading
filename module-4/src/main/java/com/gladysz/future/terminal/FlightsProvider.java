package com.gladysz.future.terminal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FlightsProvider {

    public CompletableFuture<List<Flight>> provideFlights() {

        System.out.println("Providing flights");

        return CompletableFuture.supplyAsync(() -> List.of( //uruchamia kod w osobnym wątku
                new Flight(1, "WAW", LocalDateTime.now(), LocalDateTime.now(), 1),
                new Flight(2, "WRO", LocalDateTime.now(), LocalDateTime.now(), 3),
                new Flight(3, "DUB", LocalDateTime.now(), LocalDateTime.now(), 3),
                new Flight(4, "PMI", LocalDateTime.now(), LocalDateTime.now(), 4),
                new Flight(5, "MAD", LocalDateTime.now(), LocalDateTime.now(), 2)
        ));
    }
}
