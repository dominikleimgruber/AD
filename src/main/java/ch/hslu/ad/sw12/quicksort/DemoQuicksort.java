/*
 * Copyright 2020 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw12.quicksort;


import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import ch.hslu.ad.sw12.RandomInitTask;
import ch.hslu.ad.sw12.SumTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LogManager.getLogger(DemoQuicksort.class);
    private static ForkJoinPool pool;
    private static int[] array;

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        //Initializing
        final int size = 300_000_000;
        long start;
        long end;
        array = new int[size];
        int[] check;
        pool = new ForkJoinPool();

        //Check concurrent quicksort
        initiallizing();
        check = array.clone();
        final QuicksortTask sortTask = new QuicksortTask(array);
        start = System.currentTimeMillis();
        pool.invoke(sortTask);
        end = System.currentTimeMillis();
        LOG.info("QuicksortTask  : {} msec.", (end - start));
        LOG.info("Conc. Checksum : {}", getSum());
        Arrays.sort(check);
        LOG.info("Sorted properly: {}", Arrays.equals(check, array));


        initiallizing();
        check = array.clone();
        start = System.currentTimeMillis();
        QuicksortRecursive.quicksort(array);
        end = System.currentTimeMillis();
        LOG.info("QuicksortRec.  : {} msec.", (end - start));
        LOG.info("Recu. Checksum : {}", getSum());
        Arrays.sort(check);
        LOG.info("Sorted properly: {}", Arrays.equals(check, array));

        initiallizing();
        start = System.currentTimeMillis();
        Arrays.sort(array);
        end = System.currentTimeMillis();
        LOG.info("Arrays.sort    : {} msec.", (end - start));
        LOG.info("Sort checksum  : {}", getSum());
    }

    private static void initiallizing() {
        RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);

        LOG.info("Init. Checksum : {}", getSum());
    }

    private static long getSum() {
        SumTask sumTask = new SumTask(array);
        return pool.invoke(sumTask);
    }

}
