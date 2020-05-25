package ch.hslu.ad.sw14.part1_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchMachineTest {


    @Test
    void testStateSearch() {
        assertEquals(8, SearchMachine.stateSearch("ANNSANANANANAS"));
    }

    @Test
    void testKpmSearch() {
        assertEquals(-1, SearchMachine.kmpSearch("ANNSANANANANAS", "EISBEIN"));
    }

}