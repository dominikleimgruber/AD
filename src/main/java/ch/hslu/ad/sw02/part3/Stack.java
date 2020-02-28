package ch.hslu.ad.sw02.part3;

import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T> {

    private Object[] stack;
    private int stackPointer;

    public Stack(final int size) {
        stack = new Object[size];
        stackPointer = 0;
    }

    public int getStackPointer() {
        return stackPointer;
    }

    public int getSize(){
        return stack.length;
    }

    @Override
    public void push(T element) {
        if (!isFull()) {
            stack[stackPointer] = element;
            stackPointer++;
        } else {
            throw new StackOverflowError("limit of the stack already reached, last item needs to be removed first.");
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T temp = (T) stack[--stackPointer];
            stack[stackPointer] = null;
            return temp;
        } else {
            throw new EmptyStackException();
        }
    }


    @Override
    public boolean isEmpty() {
        return stackPointer == 0;
    }

    @Override
    public boolean isFull() {
        return stackPointer >= stack.length;
    }
}
