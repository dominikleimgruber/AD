package ch.hslu.ad.sw04.Aufgabe4;

import ch.hslu.ad.sw02.part2.Node;

import java.util.Arrays;

public class HashTable<T> implements Table<T> {

    private Node<T>[] table;
    private int size;

    private class Node<E> {
        private Node<E> next;
        private E data;

        public Node(final E data, final Node<E> next, final int index) {
            this.next = next;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +

                    "data=" + data +
                    "\nnext=" + next +
                    '}';
        }
    }

    public HashTable(int size) {
        this.table = new Node[size];
    }

    public HashTable() {
        this(10);
    }

    @Override
    public boolean add(final T element) {
        if (element == null) {
            return false;
        }

        Node<T> node = search(element);
        if (element.equals(node.data)) {
            return false;
        }

        int index = getIndex(element);
        node.data = element;
        node.next = table[index];
        table[index] = node;
        size++;
        return true;
    }

    private int getIndex(final T element) {
        return Math.abs(element.hashCode()) % table.length;
    }

    @Override
    public boolean contains(T element) {
        return element.equals(search(element).data);
    }

    @Override
    public boolean remove(final T element) {
        Node<T> node = search(element);
        int index = getIndex(element);

        if (element.equals(node.data)) {
            table[index] = node.next;
            return true;
        }
        if (node.data == null) {
            return false;
        }

        node.next = node.next.next;
        return true;
    }

    private Node<T> search(final T element) {
        int index = Math.abs(element.hashCode()) % table.length;
        Node<T> node = table[index];
        Node<T> previous = node;
        
        while (node != null) {
            if (element.equals(node.data)) {
                return previous;
            }
            previous = node;
            node = node.next;
        }
        return new Node<T>(null, null, index);

    }

    @Override
    public String toString() {
        return "HashTable{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }
}
