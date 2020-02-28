package ch.hslu.ad.sw02.part3;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push() {
        Stack stack = new Stack(1);
        stack.push("hello");
        assertEquals(1, stack.getStackPointer());
    }

    @Test
    void pushIfFull() {
        Stack<String> stack = new Stack<>(1);
        stack.push("test");

        final StackOverflowError e =
                assertThrows(StackOverflowError.class, () -> stack.push("test"));
        assertEquals("limit of the stack already reached, last item needs to be removed first.", e.getMessage());
    }

    @Test
    void pop() {
        Stack<String> stack = new Stack<>(1);
        stack.push("hello");
        assertEquals("hello", stack.pop());
    }

    @Test
    void popIfEmpty() {
        final EmptyStackException e =
                assertThrows(EmptyStackException.class, ()-> new Stack<String>(1).pop());
    }

    @Test
    void isEmpty() {
        Stack<String> stack = new Stack<>(1);
        assertEquals(true, stack.isEmpty());
    }

    @Test
    void isFull() {
        Stack<String> stack = new Stack<>(1);
        stack.push("test");
        assertEquals(true, stack.isFull());
    }
}