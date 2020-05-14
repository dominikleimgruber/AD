package ch.hslu.ad.sw11.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FixedSizeHeapTest {

    private Heap<Integer> heap;
    private Integer[] sorted;
    private Integer[] unsorted;
    private final Logger LOG = LogManager.getLogger(FixedSizeHeapTest.class);

    @BeforeEach
    void setup() {
        sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        unsorted = new Integer[]{7, 3, 4, 9, 2, 8, 5, 1, 6};
        heap = new FixedSizeHeap<>(unsorted.length);
    }


    @Test
    void testGetMax() {

        for (Integer nr : unsorted) {
            heap.add(nr);
            LOG.debug(heap);
        }

        Integer[] check = new Integer[heap.size()];
        IntStream.range(0, heap.size()).forEach(f -> check[heap.size() - 1] = heap.getMax());
        Arrays.stream(check).forEach(LOG::info);
        assertArrayEquals(sorted, check);

    }

}