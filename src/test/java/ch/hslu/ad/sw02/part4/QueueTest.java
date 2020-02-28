package ch.hslu.ad.sw02.part4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void isFull() {
        Queue<String> queue = new Queue<>();

        for (int i = 0; i < 8; i++) {
            queue.push("A");
        }
        assertEquals(true, queue.isFull());
        assertEquals(false, queue.isEmpty());
    }

    @Test
    void isEmpty() {

        Queue<String> queue = new Queue<>();
        assertEquals(false, queue.isFull());
        assertEquals(true, queue.isEmpty());
    }

    @Test
    void push() {
        Queue<String> queue = new Queue<>();
        queue.push("A");
        assertEquals(1, queue.getCounter());

    }

    @Test
    void pop() {
        Queue<String> queue = new Queue<>();
        queue.push("A");
        assertEquals("A", queue.pop());
    }

    @Test
    void popFromEmpty() {
        Queue<String> queue = new Queue<>();
        assertEquals(null, queue.pop());
    }

    @Test
    void testPushWhenFull() {
        Queue<String> queue = new Queue<>();

        for (int i = 0; i < 8; i++) {
            queue.push("A");
        }
        final IllegalStateException e =
                assertThrows(IllegalStateException.class, () -> queue.push("A"));
        assertEquals("Queue is full.", e.getMessage());
    }
}