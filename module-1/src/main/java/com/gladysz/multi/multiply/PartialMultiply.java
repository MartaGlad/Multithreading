package com.gladysz.multi.multiply;

public class PartialMultiply implements Runnable {

    private final Multiplier multiplier;

    private final int[] tab;

    private final int lowerIndex;
    private final int upperIndex;


    public PartialMultiply (Multiplier multiplier, int[] tab, int lowerIndex, int upperIndex) {
        if (multiplier == null || tab == null
                || lowerIndex < 0 || upperIndex < 0 || lowerIndex > upperIndex) {
            throw new IllegalArgumentException("Invalid data");
        }

        this.multiplier = multiplier;
        this.tab = tab;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
    }


    @Override
    public void run() {

        for (int n = lowerIndex; n < upperIndex; n++) {
            tab[n] = multiplier.multiply(tab[n]);
        }
    }
}
