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
package ch.hslu.ad.sw09.buffer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Puffer mit einer begrenzten Kapazität. Der Puffer ist thread sicher.
 *
 * @param <T> Elememente des Buffers
 */
public class BoundedBufferAdapter<T> {

    private final BlockingDeque<T> deque;
    private final int maxSize;

    /**
     * Erzeugt einen Puffer mit bestimmter Kapazität.
     *
     * @param maxSize Kapazität des Puffers
     */
    public BoundedBufferAdapter(final int maxSize) {
        this.maxSize = maxSize;
        this.deque = new LinkedBlockingDeque<>(maxSize);
    }

    /**
     * Fügt ein Element in den Puffer ein, wenn dies möglich ist, wenn nicht muss der Schreiber
     * warten.
     *
     * @param elem Element zum Einfügen.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    public void put(final T elem) throws InterruptedException {
       deque.putFirst(elem);
    }

    /**
     * Fügt ein Element am Anfang in den Puffer ein, wenn dies möglich ist, wenn nicht muss der
     * Schreiber warten.
     *
     * @param elem Element zum Einfügen.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    public void push(final T elem) throws InterruptedException {
       deque.putLast(elem);
    }

    /**
     * Ein Element T speichern oder nach einem Timeout abbrechen. Falls der Puffer voll ist, warten
     * bis ein Platz frei wird.
     *
     * @param elem   zu speicherndes Element.
     * @param millis Timeout bis zum Abbruch.
     * @return true, wenn Element gespeichert wurde, false, wenn Timeout eingetreten ist.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    public boolean put(final T elem, final long millis) throws InterruptedException {
        return deque.offerFirst(elem, millis, TimeUnit.MILLISECONDS);
    }

    /**
     * Liest und entfernt ein Element aus dem Puffer, wenn dies möglich ist, wenn nicht muss der
     * Leser warten.
     *
     * @return gelesenes Element.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    public T get() throws InterruptedException {
        return deque.takeLast();
    }

    /**
     * Liest und entfernt ein Element am Anfang aus dem Puffer, wenn dies möglich ist, wenn nicht
     * muss der Leser warten.
     *
     * @return gelesenes Element.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    public T front() throws InterruptedException {
        return this.deque.takeFirst();
    }

    /**
     * Liest und entfernt ein Element am Ende aus dem Puffer, wenn dies möglich ist, wenn nicht muss
     * der Leser warten.
     *
     * @return gelesenes Element.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    public T back() throws InterruptedException {
       return  get();
    }

    /**
     * Liest und entfernt ein Element aus dem Puffer, wenn dies innert einer definierten Zeit
     * möglich ist.
     *
     * @param millis Anzahl Millisekunden, bis das Warten beendet wird.
     * @return gelesenes Element wenn erfolgreich, sonst null.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    public T get(final long millis) throws InterruptedException {
       return this.deque.pollLast(millis, TimeUnit.MILLISECONDS);
    }

    /**
     * Liefert true, wenn der Puffer leer ist.
     *
     * @return true, wenn der Puffer leer ist.
     */
    public boolean empty() {
        return this.deque.size() == 0;
    }

    /**
     * Liefert true, wenn der Puffer voll ist.
     *
     * @return true, wenn der Puffer voll ist.
     */
    public boolean full() {
        return this.deque.size() == this.maxSize;
    }

    /**
     * Liefert die Anzahl Elemente im Puffer.
     *
     * @return Anzahl Elemente im Puffer.
     */
    public int size() {
        return this.deque.size();
    }
}
