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

import ch.hslu.ad.sw11.ex02.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class QuicksortTask extends RecursiveAction {

    private static final Logger LOG = LogManager.getLogger(QuicksortTask.class);
    private static final int THRESHOLD = 20;
    private final int[] array;
    private final int min;
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }

    @Override
    protected void compute() {

        if ((this.max - this.min ) > THRESHOLD) {

            concurrent();
        } else {
          
            sequentially();
        }

    }

    private void sequentially() {
        int[] a = new int[max - min + 1];
        IntStream.range(min, max).forEach(f -> a[f - min + 1] = array[f]);

        int element;
        int j;
        for (int i = 2; i < a.length; i++) {
            element = a[i];
            a[0] = element;
            j = i;
            while (element < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = element;
        }
        IntStream.range(min, max).forEach(f -> array[f] = a[f - min + 1]);
    }


    private void concurrent() {

        int up = min;
        int down = max - 1;
        int t = array[max];
        boolean allChecked = false;
        do {
            while (array[up] < t) {
                up++;
            }
            while ((array[down] > t) && (down > up)) {
                down--;
            }
            if (down > up) {
                exchange(up, down);
                up++;
                down--;
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(up, max);

        QuicksortTask left = null;
        if (this.min < (up - 1)) {
            left = new QuicksortTask(array, this.min, (up - 1));
            left.fork();
        }
        QuicksortTask right = null;
        if ((up + 1) < this.max) {
            right = new QuicksortTask(array, (up + 1), this.max);
            right.fork();
        }

        if (left != null) left.join();
        if (right != null) right.join();
    }

    private void exchange(final int i, final int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
