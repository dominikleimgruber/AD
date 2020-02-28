package ch.hslu.ad.sw02.part2;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {

    private Node<T> currentNode;
    private Node<T> previousNode;

    public ListIterator(Node<T> currentNode) {
        this.currentNode = currentNode;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {

        if(hasNext()) {
            previousNode = currentNode;
            T element = currentNode.getElement();
            currentNode = currentNode.getNextNode();

            return element;
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        return "ListIterator{" +
                "currentNode=" + currentNode +
                ", previousNode=" + previousNode +
                '}';
    }
}
