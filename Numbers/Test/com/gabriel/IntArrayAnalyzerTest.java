package com.gabriel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntArrayAnalyzerTest {

    @Test
    void returnsCorrectValue() {
        int[] ints = new int[]{1, 4, 10};

        assertEquals(2, IntArrayAnalyzer.minNumbersBetween(ints));
    }

    @Test
    void returnsCorrectValueWhenReverseOrder() {
        int[] ints = new int[]{10, 4, 1};

        assertEquals(2, IntArrayAnalyzer.minNumbersBetween(ints));
    }

    @Test
    void returnsCorrectValueWhenMultipleEqualLengthGaps() {
        int[] ints = new int[]{1, 3, 5};

        assertEquals(1, IntArrayAnalyzer.minNumbersBetween(ints));
    }

    @Test
    void returnsCorrectValueWhenMultipleEqualNumbers() {
        int[] ints = new int[]{1, 4, 4, 10};

        assertEquals(2, IntArrayAnalyzer.minNumbersBetween(ints));
    }

    @Test
    void returnsCorrectValueWhenAllConsecutiveNumbers() {
        int[] ints = new int[]{1, 2, 3};

        assertEquals(0, IntArrayAnalyzer.minNumbersBetween(ints));
    }

    @Test
    void returnsZeroWhenAllSameNumbers() {
        int[] ints = new int[]{6, 6, 6};

        assertEquals(0, IntArrayAnalyzer.minNumbersBetween(ints));
    }

}