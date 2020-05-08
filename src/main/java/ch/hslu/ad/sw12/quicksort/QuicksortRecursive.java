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

import ch.hslu.ad.sw10.Sort;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
public class QuicksortRecursive {

    /**
     * public method exposed to client, sorts given array using QuickSort
     * Algorithm in Java.
     *
     * @param array input array.
     */
    public static void quicksort(int[] array) {
        QuicksortRecursive.quicksort(array, 0, array.length - 1);
    }

    /**
     * Recursive quicksort logic.
     *
     * @param array input array.
     * @param left  start index of the array.
     * @param right end index of the array.
     */
    public static void quicksort(int[] array, int left, int right) {
        int up = left;
        int down = right - 1;
        int t = array[right];
        boolean allChecked = false;
        if ((right - left) > 50) {
            do {
                while (array[up] < t) {
                    up++;
                }
                while ((array[down] > t) && (down > up)) {
                    down--;
                }
                if (down > up) {
                    exchange(array, up, down);
                    up++;
                    down--;
                } else {
                    allChecked = true;
                }
            } while (!allChecked);
            exchange(array, up, right);

            if (left < (up - 1)) quicksort(array, left, (up - 1));
            if ((up + 1) < right) quicksort(array, (up + 1), right);
        } else {
            Sort.selectionSort(array, left, right + 1);
        }

    }

    /**
     * Divides array from pivot, left side contains elements less than Pivot
     * while right side contains elements greater than pivot.
     *
     * @param array array to partitioned.
     * @param left  lower bound of the array.
     * @param right upper bound of the array.
     * @return the partition index.
     */
    public static int partition(int[] array, int left, int right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void exchange(final int[] array, final int i, final int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
