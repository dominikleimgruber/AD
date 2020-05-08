package ch.hslu.ad.sw10;

import java.util.stream.IntStream;

public class Sort {

    public static <T extends Comparable<? super T>> void insertionSort(final T[] a) {

        T element;
        int j;
        for (int i = 1; i < a.length; i++) {
            element = a[i];
            j = i;
            while (j > 0 && element.compareTo(a[j - 1]) < 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = element;
        }
    }

    public static void insertionSort2(final int[] a, int min, int max) {

        int j;
        int[] sorting = new int[max - min + 1];
        IntStream.range(min, max).forEach(f -> sorting[(f - min) + 1] = a[f]);

        for (int i = 2; i < sorting.length; i++) {
            int element = sorting[i];
            sorting[0] = element;
            j = i;
            while (sorting[j - 1] > element) {
                sorting[j] = sorting[j - 1];
                j--;
            }
            sorting[j] = element;
        }

        IntStream.range(min, max).forEach(f -> a[f] = sorting[(f - min) + 1]);

    }

    public static void selectionSort(final int[] a, int min, int max) {

        int smallest;
        for (int i = min; i < max - 1; i++) {
            smallest = i;
            for (int j = i + 1; j < max; j++) {
                if (a[smallest] > a[j]) {
                    smallest = j;
                }
            }

            int temp;
            temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(final T[] a) {

        int smallest;
        for (int i = 0; i < a.length - 1; i++) {
            smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[smallest].compareTo(a[j]) > 0) {
                    smallest = j;
                }
            }
            exchange(a, i, smallest);
        }
    }


    public static <T extends Comparable<? super T>> void bubbleSort(final T[] a) {

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    exchange(a, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    private static <T> void exchange(T[] a, int x, int y) {
        T temp;
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}
