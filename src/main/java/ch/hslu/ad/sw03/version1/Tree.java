package ch.hslu.ad.sw03.version1;


/**
 * Interface to define the most needed Methods to implement a tree.
 */
public interface Tree<T> {

    boolean add(T element);

    void clear();

    boolean contains(T element);

}
