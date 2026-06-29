package com.gladysz.readerswriters;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadersWritersApp {

    public static void main(String[] args) {
        Database database = new Database();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() ->
            database.insert(new Customer(UUID.randomUUID(), "John Johnson"))
        );

        executorService.submit(database::select);

        executorService.submit(() ->
            database.insert(new Customer(UUID.randomUUID(), "Mia Rodriguez"))
        );

        executorService.submit(database::select);

        executorService.submit(() ->
            database.insert(new Customer(UUID.randomUUID(), "Emma Thorn"))
        );

        executorService.submit(database::select);

        executorService.shutdown();
    }
}
