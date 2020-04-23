package ch.hslu.ad.sw10;

public class Sort {

    public static <T extends Comparable<T>> void insectionSort2(final T[] a) {

        T element;
        int j;
        for (int i = 1; i < a.length; i++) {
            a[0] = element;
            j = i;
            while (element.compareTo(a[j - 1]) < 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = element;
        }

    }

}
