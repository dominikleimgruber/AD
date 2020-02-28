package ch.hslu.ad.sw02.part4;

/**
 * Interface that contains methods needed to implement an easy first-in first-out Queue.
 *
 * @author Dominik Leimgruber
 */

public interface QueueInterface<T> {


    /**
     * Method to push an Element into the Queue. Throws an error if the queue is already full.
     *
     * @param element
     */
    void push(T element);

    /**
     * Method to take the oldest element out of the queue. Throws an error if the queue is empty.
     *
     * @return
     */
    T pop();

    /**
     * Method to check if the Queue is empty.
     *
     * @return {@code true} or {@code false}
     */
    boolean isEmpty();

    /**
     * Method to check if the Queue is full.
     *
     * @return {@code true} or {@code false}
     */
    boolean isFull();


}
