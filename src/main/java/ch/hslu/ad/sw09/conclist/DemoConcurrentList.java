/*
 * Copyright 2020 Hochschule Luzern - Informatik.
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
package ch.hslu.ad.sw09.conclist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.*;

/**
 * Demonstration einer synchrnisierten List mit n Producer und m Consumer.
 */
public final class DemoConcurrentList {

    private static final Logger LOG = LogManager.getLogger(DemoConcurrentList.class);
    private static final List<Integer> list = new LinkedList<>();
    private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    private static final ExecutorService executor1 = Executors.newCachedThreadPool();
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final List<Future<Long>> futures = new ArrayList<>();

    /**
     * Privater Konstruktor.
     */
    private DemoConcurrentList() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException                    wenn das warten unterbrochen wird.
     * @throws java.util.concurrent.ExecutionException bei Excecution-Fehler.
     */
    public static void main(final String[] args) throws InterruptedException, ExecutionException {


        long startBlockQueue = System.currentTimeMillis();
        blockQueue();
        long endBlockQueue = System.currentTimeMillis();


        futures.clear();

        long startSyncList = System.currentTimeMillis();
        syncList();
        long endSyncList = System.currentTimeMillis();


        executor.shutdown();

        LOG.info("Time sync list: {}", endSyncList - startSyncList);
        LOG.info("Time blocking queue: {}", endBlockQueue - startBlockQueue);
    }

    private static void syncList() throws ExecutionException, InterruptedException {

        List<Integer> syncList = Collections.synchronizedList(list);
        for (int i = 0; i < 3; i++) {
            futures.add(executor.submit(new Producer(syncList, 10_000_000)));
        }
        Iterator<Future<Long>> iterator = futures.iterator();
        long totProd = 0;
        while (iterator.hasNext()) {
            long sum = iterator.next().get();
            totProd += sum;
            LOG.info("SyncProd sum = " + sum);
        }
        LOG.info("SyncProd tot = " + totProd);
        Future<Long> future = executor.submit(new Consumer(syncList));
        long totCons = future.get();
        LOG.info("SyncCons tot = " + totCons);

    }

    private static void blockQueue() throws ExecutionException, InterruptedException {

        for (int i = 0; i < 3; i++) {
            futures.add(executor.submit(new ProducerBlocking(queue, 10_000_000)));
        }
        Iterator<Future<Long>> iterator = futures.iterator();
        long totProd = 0;
        while (iterator.hasNext()) {
            long sum = iterator.next().get();
            totProd += sum;
            LOG.info("BlockingProd sum = " + sum);
        }
        LOG.info("BlockingProd tot = " + totProd);
        Future<Long> future = executor.submit(new ConsumerBlocking(queue));
        long totCons = future.get();
        LOG.info("BlockingCons tot = " + totCons);
    }


}