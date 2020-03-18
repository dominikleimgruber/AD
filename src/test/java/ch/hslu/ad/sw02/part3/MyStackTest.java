package ch.hslu.ad.sw02.part3;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void push() {
        MyStack myStack = new MyStack(1);
        myStack.push("hello");
        assertEquals(1, myStack.getStackPointer());
    }

    @Test
    void pushIfFull() {
        MyStack<String> myStack = new MyStack<>(1);
        myStack.push("test");

        final StackOverflowError e =
                assertThrows(StackOverflowError.class, () -> myStack.push("test"));
        assertEquals("limit of the stack already reached, last item needs to be removed first.", e.getMessage());
    }

    @Test
    void pop() {
        MyStack<String> myStack = new MyStack<>(1);
        myStack.push("hello");
        assertEquals("hello", myStack.pop());
    }

    @Test
    void popIfEmpty() {
        final EmptyStackException e =
                assertThrows(EmptyStackException.class, ()-> new MyStack<String>(1).pop());
    }

    @Test
    void isEmpty() {
        MyStack<String> myStack = new MyStack<>(1);
        assertEquals(true, myStack.isEmpty());
    }

    @Test
    void isFull() {
        MyStack<String> myStack = new MyStack<>(1);
        myStack.push("test");
        assertEquals(true, myStack.isFull());
    }
}