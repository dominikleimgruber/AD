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
import java.util.ArrayList;
import java.util.List;
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
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final List<BigInteger> primes = new ArrayList<>();
        Callable<BigInteger> callable = () -> {
            BigInteger bi = new BigInteger(1024, new Random());
            while(bi.isProbablePrime(Integer.MAX_VALUE)){
                LOG.info("not Prime");
            }
            return bi;
        };

        final ExecutorService execurtor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        while(primes.size() < 100){
            Future<BigInteger> future = execurtor.submit(callable);
            primes.add(future.get());
        }

        try(PrintWriter pw =
                    new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream("/Users/dominikleimgruber/Desktop/primes.txt"), Charset.forName("UTF-8"))));
        ){
            primes.forEach(f -> pw.println(f.toString().substring(0, 20)));
        }catch (IOException e){
            LOG.error(e);
        }
    }
}

