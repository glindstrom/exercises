package com.gabriel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntArrayAnalyzer {
    public static int minNumbersBetween(int[] ints) {
        List<Integer> sortedAndUniqueInts = Arrays.stream(ints)
                .boxed()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        if (sortedAndUniqueInts.size() < 2) {
            return 0;
        }

        return IntStream.range(0, sortedAndUniqueInts.size() - 1)
                .map(i -> numbersBetween(sortedAndUniqueInts.get(i), sortedAndUniqueInts.get(i + 1)))
                .min()
                .getAsInt();
    }

    private static int numbersBetween(int i, int j) {
        return Math.abs(i - j) - 1;
    }

}
