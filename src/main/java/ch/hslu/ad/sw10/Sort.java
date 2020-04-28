package ch.hslu.ad.sw10;

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

        boolean swapped;
        for (int i = 0; i < a.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < a.length - i - 1; j++){
                if(a[j].compareTo(a[j + 1]) > 0){
                    swapped = true;
                    exchange(a, j, j + 1);
                }
            }
            if(!swapped){
                return;
            }
        }
    }

    private static <T> void exchange(T[] a, int x, int y){
        T temp;
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}
