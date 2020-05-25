package ch.hslu.ad.sw14.part4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuicksearchTest {

    @Test
    void testQuickSearch() {
        assertEquals(8, Quicksearch.quickSearch("ANNSANANANANAS", "ANANAS"));

    }

    @Test
    void testOptimalMismatch() {
        int i = Quicksearch.optimalMismatch("ANNSANANANANAS", "ANANAS");
        assertEquals(8, i);

    }
}