package com.gladysz.future.terminal;

import java.util.concurrent.CompletableFuture;

public class CompanyProvider {

    public CompletableFuture<String> provideName(int companyId) {
        System.out.println("Providing name for ID: " + companyId);

        return CompletableFuture.supplyAsync(() -> {
            switch (companyId) {
                case 1:
                    return "EasyFly";
                case 2:
                    return "FlyFast";
                case 3:
                    return "CheapFlights";
                case 4:
                    return "CharterFlights";
                default:
                    throw new IllegalArgumentException("Company not know");
            }
        });
    }
}
