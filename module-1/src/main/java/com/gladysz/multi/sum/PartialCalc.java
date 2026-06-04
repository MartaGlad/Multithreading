package com.gladysz.multi.sum;

public class PartialCalc extends Thread {

    private final Reducer reducer;

    private final int[] elements;

    private final int lowerIndex;
    private final int upperIndex;

    public PartialCalc(Reducer reducer, int[] elements,  int lowerIndex, int upperIndex) {

        this.reducer = reducer;
        this.elements = elements;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
    }


    @Override
    public void run() {

        for (int n = lowerIndex; n < upperIndex; n++) {
            reducer.add(elements[n]);
        }
    }
}
