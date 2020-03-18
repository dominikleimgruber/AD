package ch.hslu.ad.sw04.Aufgabe1;


import java.util.Arrays;

public class HashTable<T> implements Table<T> {

    private final static int DEFAULT_SIZE = 10;
    private Object[] table;
    private int size;

    public HashTable(final int size) {
        this.table = new Object[size];
        this.size = 0;
    }

    public HashTable() {
        this(DEFAULT_SIZE);
    }

    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        }

        int index = generateIndex(element);

        if (element.equals(table[index])) {
            return false;
        }

        table[index] = element;
        size++;
        return true;

    }

    @Override
    public boolean contains(T element) {
        if (element == null) {
            return false;
        }
        int index = generateIndex(element);
        return element.equals(table[index]);
    }

    @Override
    public boolean remove(final T element) {
        int index = generateIndex(element);

        if (element.equals(table[index])) {
            table[index] = null;
            size--;
            return true;
        }
        return false;
    }

    private int generateIndex(final T element) {
        return Math.abs(element.hashCode()) % table.length;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }
}

