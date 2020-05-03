package ch.hslu.ad.sw11.ex02;

public final class Sort {

    public static <T extends Comparable<? super T>> void quicksort(final T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static <T extends Comparable<? super T>> void quicksort(final T[] a, final int left, final int right) {

        int up = left;
        int down = right - 1;
        T t = a[right];
        boolean allChecked = false;
        do {
            while (a[up].compareTo(t) < 0) {
                up++;
            }
            while ((a[down].compareTo(t) >= 0) && (down > up)) {
                down--;
            }
            if (down > up) {
                exchange(a, up, down);
                up++;
                down--;
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(a, up, right);
        if (left < (up - 1)) quicksort(a, left, (up - 1));
        if ((up + 1) < right) quicksort(a, (up + 1), right);
    }

    private static <T> void exchange(T[] a, int firstIndex, int secondIndex) {
        T temp;
        temp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = temp;
    }
}
