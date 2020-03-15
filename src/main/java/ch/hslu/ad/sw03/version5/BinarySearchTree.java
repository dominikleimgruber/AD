package ch.hslu.ad.sw03.version5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinarySearchTree<T extends Comparable> implements Tree<T> {

    private class Node<E>{
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(final E data) {
            this.data = data;
        }
    }

    private static final Logger LOG = LogManager.getLogger(BinarySearchTree.class);
    private Node<T> root;
    private int size;

    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T element) {
        return false;
    }


    private Node<T> search(final T element){

    }
}
