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
package ch.hslu.ad.sw12.mergesort;


import ch.hslu.ad.sw12.array.init.RandomInitTask;
import ch.hslu.ad.sw12.array.sum.SumTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * Performance Vergleich der Mergesort-Implementation.
 */
public final class DemoMergesort {

    private static final Logger LOG = LogManager.getLogger(DemoMergesort.class);
    private static ForkJoinPool pool;
    private static int[] array;

    /**
     * Privater Konstruktor.
     */
    private DemoMergesort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {


        final int size = 300_000_000;
        array = new int[size];
        pool = new ForkJoinPool();

        LOG.info("Threshold: 100");

        initiallizing();
        long start = System.currentTimeMillis();
        final MergesortTask sortTask = new MergesortTask(array);
        pool.invoke(sortTask);
        long end = System.currentTimeMillis();
        LOG.info("Conc. Mergesort : {} msec.", (end - start));
        LOG.info("Merge Checksum  : {}", getSum());

        initiallizing();
        start = System.currentTimeMillis();
        Arrays.sort(array);
        end = System.currentTimeMillis();
        LOG.info("Seq. Arrays.sort() : {} msec.", (end - start));
        LOG.info("Arrays.sort Checksum  : {}", getSum());

        initiallizing();
        start = System.currentTimeMillis();
        MergesortRecursive.mergeSort(array);
        end = System.currentTimeMillis();
        LOG.info("MergesortRec.   : {} msec.", (end - start));
        LOG.info("Sort checksum   : {}", getSum());
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
