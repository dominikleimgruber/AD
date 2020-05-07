package ch.hslu.ad.sw11.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Playground {

    private static final Logger LOG = LogManager.getLogger(Playground.class);

    public static void main(String[] args) {
        Integer[] unsorted500 = new Integer[75_000_000];
        IntStream.range(0, unsorted500.length).forEach(f -> {
            unsorted500[f] = new Random().nextInt(Integer.MAX_VALUE);
            if(f == 74_999_999) LOG.info(f);
        });

        /*IntStream.range(0, 300_000_000).forEach( f -> {
                if(f % 2 == 0){
                    unsorted500[f] = f * 8 ;
                }else if(f % 2 == 1) {
                    unsorted500[f] = f * 5 * (int) Math.pow(-1,f);
                }
        });*/


        long start = System.currentTimeMillis();
        Sort.quicksort(unsorted500.clone());
        long end = System.currentTimeMillis();
        LOG.info("First Measurement in ms: {}", end - start);

        start = System.currentTimeMillis();
        Sort.quicksort(unsorted500.clone());
        end = System.currentTimeMillis();
        LOG.info("Second Measurement in ms: {}", end - start);

        Integer[] copy = unsorted500.clone();
        Arrays.sort(copy);

        start = System.currentTimeMillis();
        Sort.quicksort(unsorted500);
        end = System.currentTimeMillis();
        LOG.info("Third Measurement in ms: {}", end - start);

        LOG.info(Arrays.equals(copy, unsorted500));

    }

}
