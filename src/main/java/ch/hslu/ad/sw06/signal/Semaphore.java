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
package ch.hslu.ad.sw06.signal;

/**
 * Ein nach oben nicht begrenztes Semaphor, d.h. der Semaphorenzähler kann
 * unendlich wachsen.
 */
public final class Semaphore {

    private int sema; // Semaphorenzähler
    private final int limit; // max Value of sema
    private int count; // Anzahl der wartenden Threads.

    /**
     * Erzeugt ein Semaphore mit 0 Passiersignalen. Maximale ein Passiersignal möglich.
     */
    public Semaphore() {
        this(0, 1);
    }

    /**
     * Erzeugt ein Semaphore mit einem Initalwert für den Semaphorenzähler. Der Initialwert wird ebenfalls als Limit für
     * die Semaphore festgelegt.
     *
     * @param permits Anzahl Passiersignale zur Initialisierung. Ebenfalls maximale Anazahl Passiersignale.
     * @throws IllegalArgumentException wenn der Initalwert negativ ist.
     */
    public Semaphore(final int permits) throws IllegalArgumentException {

        this(permits, permits);
    }

    /**
     * Erzeugt ein nach oben begrenztes Semaphore.
     *
     * @param permits Anzahl Passiersignale zur Initialisierung.
     * @param limit   maximale Anzahl der Passiersignale.
     * @throws IllegalArgumentException wenn Argumente ungültige Werte besitzen.
     */
    public Semaphore(final int permits, final int limit) throws IllegalArgumentException {
        if (permits < 0 || permits > limit) {
            throw new IllegalArgumentException(permits + " < 0");
        }
        this.sema = permits;
        this.limit = limit;
        this.count = 0;


    }

    /**
     * Entspricht dem P() Eintritt (Passieren) in einen synchronisierten
     * Bereich, wobei mitgezählt wird, der wievielte Eintritt es ist. Falls der
     * Zähler null ist wird der Aufrufer blockiert.
     *
     * @throws InterruptedException falls das Warten unterbrochen
     *                              wird.
     */
    public synchronized void acquire() throws InterruptedException, IllegalArgumentException {
        acquire(1);
    }

    public synchronized void acquire(final int permits) throws InterruptedException, IllegalArgumentException{
        if (permits < 0 || permits > this.limit) {
            throw new IllegalArgumentException("Requested permits are either lower than zero or higher than the allowed limit");
        }

        while (permits > sema) {
            count += permits;
            this.wait();
            count -= permits;
        }
        sema -= permits;
    }

    /**
     * Entspricht dem V() Verlassen (Freigeben) eines synchronisierten
     * Bereiches, wobei ebenfalls mitgezählt wird, wie oft der Bereich verlassen
     * wird.
     */
    public synchronized void release() {
        release(1);
    }

    public synchronized void release(final int permits){
         if(permits < 0){
             throw new IllegalArgumentException("permits below zero");
         }
         if((sema + permits) > this.limit){
             throw new IllegalArgumentException("permits and already allowed passes are higher than the allowed limit");
         }

         sema += permits;
         this.notifyAll();

    }

    /**
     * Lesen der Anzahl wartenden Threads.
     *
     * @return Anzahl wartende Threads.
     */
    public synchronized int pending() {
        return count;
    }
}
