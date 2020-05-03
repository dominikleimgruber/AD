package ch.hslu.ad.sw11.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeHeapTest {

    private Heap<Integer> heap;
    private Integer[] sorted;
    private Integer[] unsorted;
    private final Logger LOG = LogManager.getLogger(FixedSizeHeapTest.class);

    @BeforeEach
    void setup() {
        //sorted = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        unsorted = new Integer[100_000];
        IntStream.range(0,100_000).forEach(f -> unsorted[f] = new Random().nextInt());
        sorted = unsorted.clone();
        Arrays.sort(sorted);
        //unsorted = new Integer[]{7, 3, 4, 9, 2, 8, 5, 1, 6};
        heap = new FixedSizeHeap<>(1000_000);
    }


    @Test
    void testGetMax() {

        for(Integer nr : unsorted){
            heap.add(nr);
            //LOG.debug(heap);
        }
        Integer[] check = new Integer[100_000];
        for(int i = check.length - 1; i >= 0; i--){
            check[i] = heap.getMax();
            //LOG.debug(heap);

        }
        for(Integer nr : check){
            LOG.info(nr);
        }
        assertArrayEquals(sorted, check);

    }

}