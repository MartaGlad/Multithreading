package com.gladysz.future.terminal;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Terminal {

    private static final FlightsProvider flightsProvider = new FlightsProvider();
    private static final CompanyProvider companyProvider = new CompanyProvider();


    public static void main(String[] args) {

        flightsProvider.provideFlights().thenCompose(flights -> {

            final List<CompletableFuture<Flight>> updatedFlights = updateFlights(flights);

            return collectAllFlightsFutures(updatedFlights);

        }).thenAccept(Terminal::printResult).join();
    }


    private static List<CompletableFuture<Flight>> updateFlights(List<Flight> flights) {

        return flights.stream().map(flight ->

                companyProvider.provideName(flight.getCompanyId())
                        .thenApply(companyName ->
                        {
                            flight.setCompanyName(companyName);

                            return flight;

                        })).collect(Collectors.toList());
    }


    private static CompletableFuture<List<Flight>> collectAllFlightsFutures(
            List<CompletableFuture<Flight>> updatedFlights) {

        return CompletableFuture.allOf(updatedFlights.toArray(new CompletableFuture[0]))
                .thenApply(v -> updatedFlights.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList()));
    }


    private static void printResult (List<Flight> updatedFlights) {
        System.out.println();
        System.out.println("----TERMINAL----");
        System.out.println(updatedFlights);
    }
}
