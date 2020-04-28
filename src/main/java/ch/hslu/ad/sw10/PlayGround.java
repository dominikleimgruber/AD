package ch.hslu.ad.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.stream.IntStream;

public class PlayGround {


    private static final Logger LOG = LogManager.getLogger(PlayGround.class);

    public static void main(String[] args) {


        Integer[] unsorted400 = new Integer[400_000];
        Integer[] unsorted100 = new Integer[100_000];
        Integer[] unsorted200 = new Integer[200_000];


        IntStream.range(0, 400_000).forEach(f -> unsorted400[f] = new Random().nextInt(Integer.MAX_VALUE));
        IntStream.range(0, 100_000).forEach(f -> unsorted100[f] = unsorted400[f]);
        IntStream.range(0, 200_000).forEach(f -> unsorted200[f] = unsorted400[f]);

        LOG.info("100'000 with Insertion: {}", insertion(unsorted100.clone()));
        LOG.info("100'000 with Selection: {}", selection(unsorted100.clone()));
        LOG.info("100'000 with Bubble: {}", bubble(unsorted100.clone()));

        LOG.info("200'000 with Insertion: {}", insertion(unsorted200.clone()));
        LOG.info("200'000 with Selection: {}", selection(unsorted200.clone()));
        LOG.info("200'000 with Bubble: {}", bubble(unsorted200.clone()));

        LOG.info("400'000 with Insertion: {}", insertion(unsorted400.clone()));
        LOG.info("400'000 with Selection: {}", selection(unsorted400.clone()));
        LOG.info("400'000 with Bubble: {}", bubble(unsorted400.clone()));
    }


    private static long bubble(Integer[] a) {
        long start = System.currentTimeMillis();
        Sort.bubbleSort(a);
        long end = System.currentTimeMillis();

        return end - start;
    }

    private static long insertion(Integer[] a) {
        long start = System.currentTimeMillis();
        Sort.insertionSort(a);
        long end = System.currentTimeMillis();

        return end - start;
    }

    private static long selection(Integer[] a) {

        long start = System.currentTimeMillis();
        Sort.selectionSort(a);
        long end = System.currentTimeMillis();

        return end - start;
    }

}
