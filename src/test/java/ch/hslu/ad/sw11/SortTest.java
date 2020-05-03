package ch.hslu.ad.sw11;

import ch.hslu.ad.sw11.ex02.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    private static final Logger LOG = LogManager.getLogger(SortTest.class);

    Integer[] unsorted;
    Integer[] reverseSorted;
    Integer[] sorted;


    @BeforeEach
    void setup() {
        unsorted = new Integer[]{26, 2, 32, 4, 39, 3, 1};
        sorted = new Integer[]{1, 2, 3, 4, 26, 32, 39};
        reverseSorted = new Integer[]{39, 32, 26, 4, 3, 2, 1};
    }

    @Test
    void testQuicksort() {
        Integer[] copyUnsorted = unsorted.clone();
        Arrays.sort(copyUnsorted);
        Sort.quicksort(unsorted);
        assertArrayEquals(copyUnsorted, unsorted);
    }
}