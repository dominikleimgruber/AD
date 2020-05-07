package ch.hslu.ad.sw11.ex03;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class FixedSizeHeap<T extends Comparable<T>> implements Heap<T> {

    private final Object[] heap;
    private int size;

    public FixedSizeHeap(int heapSize) {
        this.heap = new Object[heapSize];
    }


    @Override
    public T getMax() {

        if (size == 0) {
            throw new IllegalStateException("heap is empty");
        }

        T max = (T) heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;

        heapifdown();
        size--;
        return max;
    }


    @Override
    public boolean add(T value) {
        if (heap[0] == null) {
            heap[0] = value;
            size++;
            return true;
        }
        if (isFull()) {
            return false;
        }

        heap[size] = value;

        heapifyup();
        size++;
        return true;
    }


    @Override
    public boolean isFull() {
        return heap.length == size;
    }

    @Override
    public int size() {
        return size;
    }


    private void heapifdown() {
        T value = (T) heap[0];
        int parent = 0;
        int biggerIndex;
        T left;

        while (hasLeft(parent)) {
            biggerIndex = leftChild(parent);
            left = (T) heap[biggerIndex];
            if (hasRight(parent) && left.compareTo((T) heap[rightChild(parent)]) < 0) {
                biggerIndex = rightChild(parent);
            }

            if (value.compareTo((T) heap[biggerIndex]) < 0) {
                exchange(biggerIndex, parent);
                parent = biggerIndex;
            } else {
                return;
            }

        }
    }

    private boolean hasRight(int parent) {
        int right = rightChild(parent);
        return right < size && heap[right] != null;
    }

    private boolean hasLeft(int parent) {
        int left = leftChild(parent);
        return left < size && heap[left] != null;
    }

    private void heapifyup() {
        T value = (T) heap[size];
        int child = size;
        int parent = parent(child);

        while (value.compareTo((T) heap[parent]) > 0) {
            heap[child] = heap[parent];
            heap[parent] = value;
            child = parent;
            parent = parent(child);
        }
    }

    private void exchange(int i, int j) {
        T temp = (T) heap[i];
        heap[i] = heap[j];
        heap[j] = temp;

    }

    private int leftChild(final int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(final int pos) {
        return 2 * (pos + 1);
    }

    private int parent(final int child) {
        return (child - 1) / 2;
    }

    @Override
    public String toString() {
        return "FixedSizeHeap{" +
                "heap=" + Arrays.toString(heap) +
                '}';
    }
}
