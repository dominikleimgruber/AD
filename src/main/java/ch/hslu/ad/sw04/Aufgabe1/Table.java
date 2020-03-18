package ch.hslu.ad.sw04.Aufgabe1;

public interface Table<T> {

    boolean add(final T element);

    boolean contains(final T element);

    boolean remove(T element);

}
