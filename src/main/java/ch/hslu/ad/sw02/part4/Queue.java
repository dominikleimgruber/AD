package ch.hslu.ad.sw02.part4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Queue<T> implements QueueInterface<T> {

    private static final Logger LOG = LogManager.getLogger(Queue.class);
    private Object[] queue;
    private int head;
    private int tail;
    private int counter;

    public Queue() {
        this.queue = new Object[8];
        this.tail = 0;
        this.head = 0;
        this.counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public boolean isFull() {
        return counter >= queue.length;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public void push(final T element) {

        if (!isFull()) {
            queue[tail] = element;

            if (tail < queue.length - 1) {
                tail++;
            } else {
                tail = 0;
            }

            counter++;
            LOG.info(this);

        } else {
            throw new IllegalStateException("Queue is full.");
        }

    }

    @Override
    public T pop() {

        if (!isEmpty()) {
            T temp = (T) queue[head];
            queue[head] = null;

            if (head < queue.length - 1) {
                head++;
            } else {
                head = 0;
            }

            counter--;
            LOG.info(this);
            return temp;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queue=" + Arrays.toString(queue) +
                ", head=" + head +
                ", tail=" + tail +
                ", count=" + counter +
                '}';
    }
}
