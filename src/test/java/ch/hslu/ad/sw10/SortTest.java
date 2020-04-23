package ch.hslu.ad.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    private static final Logger LOG = LogManager.getLogger(SortTest.class);

    @Test
    void testInsectionSort2Functionality() {

        Integer[] a = {1, 65, 3, 8, 4, 22, 6, 974, 30};
        Integer[] b = Arrays.copyOf(a, a.length);
        Sort.insectionSort2(a);
        Arrays.sort(b);
        assertArrayEquals(a, b);
    }

    @Test
    void insectionSort2Runtime100kRandom() {

        Integer[] a = new Integer[100_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(Integer.MAX_VALUE);
        }
        long startTime = System.currentTimeMillis();
        Sort.insectionSort2(a);
        long endTime = System.currentTimeMillis();
        LOG.info("Runtime: {}", endTime - startTime);

    }

    @Test
    void insectionSort2Runtime100kSorted() {

        Integer[] a = new Integer[100_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        long startTime = System.currentTimeMillis();
        Sort.insectionSort2(a);
        long endTime = System.currentTimeMillis();
        LOG.info("Runtime: {}", endTime - startTime);

    }

    @Test
    void insectionSort2Runtime100kReverseSorted() {

        Integer[] a = new Integer[100_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length - i;
        }
        long startTime = System.currentTimeMillis();
        Sort.insectionSort2(a);
        long endTime = System.currentTimeMillis();
        LOG.info("Runtime: {}", endTime - startTime);

    }

    @Test
    void insectionSort2Runtime200k() {

        Integer[] a = new Integer[200_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(Integer.MAX_VALUE);
        }
        long startTime = System.currentTimeMillis();
        Sort.insectionSort2(a);
        long endTime = System.currentTimeMillis();
        LOG.info("Runtime: {}", endTime - startTime);
    }

    @Test
    void insectionSort2Runtime200kSorted() {

        Integer[] a = new Integer[200_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        long startTime = System.currentTimeMillis();
        Sort.insectionSort2(a);
        long endTime = System.currentTimeMillis();
        LOG.info("Runtime: {}", endTime - startTime);

    }

    @Test
    void insectionSort2Runtime200kReverseSorted() {

        Integer[] a = new Integer[200_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length - i;
        }
        long startTime = System.currentTimeMillis();
        Sort.insectionSort2(a);
        long endTime = System.currentTimeMillis();
        LOG.info("Runtime: {}", endTime - startTime);

    }

    @Test
    void insectionSort2Runtime400k() {

        Integer[] a = new Integer[400_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(Integer.MAX_VALUE);
        }
        long startTime = System.currentTimeMillis();
        Sort.insectionSort2(a);
        long endTime = System.currentTimeMillis();
        LOG.info("Runtime: {}", endTime - startTime);
    }

    @Test
    void insectionSort2Runtime400kSorted() {

        Integer[] a = new Integer[400_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        long startTime = System.currentTimeMillis();
        Sort.insectionSort2(a);
        long endTime = System.currentTimeMillis();
        LOG.info("Runtime: {}", endTime - startTime);

    }

    @Test
    void insectionSort2Runtime400kReverseSorted() {

        Integer[] a = new Integer[400_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length - i;
        }
        long startTime = System.currentTimeMillis();
        Sort.insectionSort2(a);
        long endTime = System.currentTimeMillis();
        LOG.info("Runtime: {}", endTime - startTime);

    }
}