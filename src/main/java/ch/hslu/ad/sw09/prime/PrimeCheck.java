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
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 100 grosse Primzahlen produzieren.
 */
public final class PrimeCheck {

    private static final Logger LOG = LogManager.getLogger(PrimeCheck.class);

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
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int n = 1;

         
        while (n <= 100) {
            Callable<Integer> callable = () -> {
                BigInteger bi = new BigInteger(1024, new Random());
                //BigInteger bi = new BigInteger(1024, Integer.MAX_VALUE, new Random());
                if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                    //LOG.info(n + ": " + bi.toString().substring(0, 20) + "...");
                    try (PrintWriter pw =
                                 new PrintWriter(new BufferedWriter(new OutputStreamWriter
                                         (new FileOutputStream("/Users/dominikleimgruber/Desktop/prim.txt"), StandardCharsets.UTF_8)));
                    ) {
                        pw.println(bi.toString().substring(0, 20));
                        pw.close();
                    } catch (IOException ioe) {
                        LOG.error(ioe);
                    }
                    return 1;
                }
                return 0;
            };
            ExecutorService executor = Executors.newCachedThreadPool();
            Future<Integer> future = executor.submit(callable);
            n += future.get();
        }
    }
}

