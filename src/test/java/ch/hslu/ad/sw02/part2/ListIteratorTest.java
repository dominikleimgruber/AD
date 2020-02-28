package ch.hslu.ad.sw02.part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListIteratorTest {

    @Test
    void hasNextTrue() {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("hello");
        myList.add("hello2");
        ListIterator<String> i = myList.iterator();
        assertEquals(true, i.hasNext());
    }

    @Test
    void hasNextFalse() {
        LinkedList<String> myList = new LinkedList<>();
        ListIterator<String> i = myList.iterator();
        assertEquals(false, i.hasNext());
    }

    @Test
    void next() {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("hello");
        myList.add("hello2");
        ListIterator<String> i = myList.iterator();
        assertEquals("hello2", i.next());
    }

    @Test
    void nextEmptyList() {
        LinkedList<String> myList = new LinkedList<>();
        ListIterator<String> i = myList.iterator();
        assertEquals(null, i.next());
    }
}