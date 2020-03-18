package ch.hslu.ad.sw04.Aufgabe3;


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

        if (element == null || isFull()) {
            return false;
        }

       int index = search(element);
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
        return element.equals(table[search(element)]);
    }

    @Override
    public boolean remove(final T element) {

        if(element == null){
            return false;
        }

        int index = search(element);
        if (element.equals(table[index])) {
            table[index] = null;
            size--;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return size == table.length;
    }

    private int search(final T element) {

        int index = Math.abs(element.hashCode()) % table.length;
        int count = 0;

        while (table[index] != null && count < table.length) {
            if (index == table.length) {
                index = 0;
            }
            if(element.equals(table[index])){
                return index;
            }
            index++;
            count++;
        }
        return index;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }
}

