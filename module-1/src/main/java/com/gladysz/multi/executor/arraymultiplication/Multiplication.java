package com.gladysz.multi.executor.arraymultiplication;

public class Multiplication implements Runnable {
    
    private final int[] array1;
    private final int[] array2;

    private final long[] resultArray;

    private final int startIndex;
    private final int endIndex;

    public Multiplication(int[] array1, int[] array2, long[] resultArray, int startIndex, int endIndex) {

        if (array1 == null || array2 == null || resultArray == null
                || array1.length != array2.length || array1.length != resultArray.length
                || startIndex < 0 || endIndex < 0 || startIndex > endIndex || endIndex > array1.length) {
            throw new IllegalArgumentException("Invalid data");
        }

        this.array1 = array1;
        this.array2 = array2;
        this.resultArray = resultArray;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }


    @Override
    public void run() {

        for (int i = startIndex; i < endIndex; i++) {

            resultArray[i] = (long) array1[i] * array2[i];
        }
    }
}
 