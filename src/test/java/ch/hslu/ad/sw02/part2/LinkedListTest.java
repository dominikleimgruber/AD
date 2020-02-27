package ch.hslu.ad.sw02.part2;

import ch.hslu.ad.sw01.part1.Allocation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() {
        LinkedList<Allocation> list = new LinkedList<Allocation>();
        list.add(new Allocation(1024, 1024));
        list.add(new Allocation(0, 1024));
        assertEquals(2, list.getSize());
    }

    @Test
    void testContains() {
        LinkedList<Allocation> list = new LinkedList<Allocation>();
        list.add(new Allocation(1024, 1024));
        list.add(new Allocation(0, 1024));
        Allocation alloc = new Allocation(2048, 1024);
        list.add(alloc);
        assertEquals(true, list.contains(alloc));
    }

    @Test
    void testGetAndDeleteReasonable(){
        LinkedList<Allocation> list = new LinkedList<Allocation>();
        list.add(new Allocation(1024, 1024));
        Allocation alloc = new Allocation(0, 1024);
        list.add(alloc);
        Allocation alloc2 = new Allocation(2048, 1024);
        list.add(alloc2);

        assertEquals(true, alloc.equals(list.getAndDelete(1)));
        assertEquals(true, list.contains(alloc2));
    }

    @Test
    void testGetAndDeleteLast(){
        LinkedList<Allocation> list = new LinkedList<Allocation>();
        list.add(new Allocation(1024, 1024));
        Allocation alloc = new Allocation(0, 1024);
        list.add(alloc);
        assertEquals(1024, list.getAndDelete(1).getCapacity());
    }

    @Test
    void testGetAndDeleteMore(){
        LinkedList<Allocation> list = new LinkedList<Allocation>();
        list.add(new Allocation(1024, 1024));
        assertEquals(null, list.getAndDelete(7));
    }

    @Test
    void testGetAndDeleteLess(){
        LinkedList<Allocation> list = new LinkedList<Allocation>();
        list.add(new Allocation(1024, 1024));
        assertEquals(null, list.getAndDelete(-7));
    }

}