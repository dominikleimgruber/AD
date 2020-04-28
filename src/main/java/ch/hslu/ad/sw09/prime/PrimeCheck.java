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
package ch.hslu.ad.sw09.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 100 grosse Primzahlen produzieren.
 */
public final class PrimeCheck {

    private static final Logger LOG = LogManager.getLogger(PrimeCheck.class);
    private static final int NUMBER_OF_PRIMES = 100;
    private static final String FILE = "/Users/dominikleimgruber/Desktop/primes.txt";

    /**
     * Privater Konstruktor.
     */
    public PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final BlockingQueue<BigInteger> primesAsync = new ArrayBlockingQueue<>(NUMBER_OF_PRIMES);
        final BlockingQueue<BigInteger> primesSync = new ArrayBlockingQueue<>(NUMBER_OF_PRIMES);

        long startAsync = System.currentTimeMillis();
        findBigPrimesAsync(primesAsync);
        long endAsync = System.currentTimeMillis();

        long startSync = System.currentTimeMillis();
        findBigPrimeSync(primesSync);
        long endSync = System.currentTimeMillis();

        LOG.info("Time Async: {}", (endAsync - startAsync));
        LOG.info("Time Sync: {}", (endSync - startSync));

        writeData(primesAsync);


    }

    private static void writeData(final BlockingQueue<BigInteger> primes) {
        try (PrintWriter pw =
                     new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(FILE), StandardCharsets.UTF_8)))
        ) {
            primes.forEach(f -> pw.println(f.toString().substring(0, 20)));
            pw.flush();
        } catch (IOException e) {
            LOG.error(e);
        }
        LOG.debug("File written");
    }

    private static void findBigPrimesAsync(final BlockingQueue<BigInteger> queue) {
        final List<Future<BigInteger>> futures = new ArrayList<>();
        final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Callable<BigInteger> callable = () -> {
            BigInteger bi = new BigInteger(1024, new Random());
            while (!bi.isProbablePrime(Integer.MAX_VALUE)) {
                bi = new BigInteger(1024, new Random());
            }
            return bi;
        };

        for (int i = 0; i < NUMBER_OF_PRIMES; i++) {
            futures.add(executor.submit(callable));
        }
        futures.forEach(f -> {
            try {
                LOG.debug("got result, Async");
                queue.offer(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }

    private static void findBigPrimeSync(final BlockingQueue<BigInteger> queue) {
        int n = 1;
        while (n < NUMBER_OF_PRIMES) {
            BigInteger bi = new BigInteger(1024, new Random());
            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                queue.offer(bi);
                LOG.debug("got result sync");
                n++;
            }
        }
    }
}

