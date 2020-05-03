package ch.hslu.ad.sw11.ex03;

public interface Heap<T extends Comparable<T>> {


    T getMax();

    boolean add(T value);

    boolean isFull();

    int size();

}
