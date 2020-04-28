package ch.hslu.ad.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;


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
    void testInsertionSort() {
        Sort.insertionSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void testInsertionSortReverse() {
        Sort.insertionSort(reverseSorted);
        assertArrayEquals(sorted, reverseSorted);
    }

    @Test
    void testInsertionSorted() {
        Integer[] copy = sorted.clone();
        Sort.insertionSort(sorted);
        assertArrayEquals(copy, sorted);
    }

    @Test
    void testSelectionSort() {
        Sort.selectionSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void testSelectionSortReverse() {
        Sort.selectionSort(reverseSorted);
        assertArrayEquals(sorted, reverseSorted);
    }

    @Test
    void testSelectionSortSorted() {
        Integer[] copy = sorted.clone();
        Sort.selectionSort(sorted);
        assertArrayEquals(copy, sorted);
    }

    @Test
    void testBubbleSort() {
        Sort.bubbleSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void testBubbleSortReverse() {
        Sort.bubbleSort(reverseSorted);
        assertArrayEquals(sorted, reverseSorted);
    }

    @Test
    void testBubbleSortSorted() {
        Integer[] copy = sorted.clone();
        Sort.bubbleSort(sorted);
        assertArrayEquals(copy, sorted);
    }


}