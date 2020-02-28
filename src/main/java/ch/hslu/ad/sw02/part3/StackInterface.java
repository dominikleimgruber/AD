package ch.hslu.ad.sw02.part3;

/**
 * Interface which contains the needed methods to implement a Stack (Frist-In, Last-Out) that contains Strings.
 */

public interface StackInterface<T> {

    /**
     * Method to put a String into the Stack. Throws a StackOverflow error, if the stack is already full.
     *
     * @param element String element which will be pushed to the Stack, if there is a free spot.
     */
    void push(final T element);

    /**
     * Method that gives the latest String object out and removes it from the stack.
     *
     * @return latest
     */
    T pop();

    /**
     * Method to check if the Stack is empty or not.
     *
     * @return {@code true} or {@code false}
     */
    boolean isEmpty();

    /**
     * Method to check if the Stack is full or not.
     *
     * @return {@code true} or {@code false}
     */
    boolean isFull();

}
