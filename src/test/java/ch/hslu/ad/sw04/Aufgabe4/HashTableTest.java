package ch.hslu.ad.sw04.Aufgabe4;

import ch.hslu.ad.sw01.part1.Allocation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void add() {
        HashTable<Allocation> table = new HashTable<>();
        Allocation alloc1 = new Allocation(1024, 1024);
        table.add(alloc1);
        assertEquals("HashTable{table=[null, null, null, null, Node{data=Allocation{startAddress=1024, " +
                "capacity=1024}\nnext=null}, null, null, null, null, null], size=1}", table.toString());
    }

    @Test
    void addSameSpot() {
        HashTable<Allocation> table = new HashTable<>();
        table.add(new Allocation(1024, 2048));
        Allocation alloc2 = new Allocation(2024, 2048);
        table.add(alloc2);
        assertEquals("HashTable{table=[null, null, null, null, Node{data=Allocation{startAddress=2024, capacity=2048}\n" +
                "next=Node{data=Allocation{startAddress=1024, capacity=2048}\nnext=null}}, null, null, null, null, null], size=2}", table.toString());
    }

    @Test
    void addWithNegativHash() {
        HashTable<Allocation> table = new HashTable<>();
        Allocation alloc1 = new Allocation(-1024, 2048);
        table.add(alloc1);
        assertEquals("HashTable{table=[null, null, null, null, Node{data=Allocation{startAddress=-1024, " +
                "capacity=2048}\nnext=null}, null, null, null, null, null], size=1}", table.toString());
    }

    @Test
    void addNull() {
        HashTable<Allocation> table = new HashTable<>();
        assertFalse(table.add(null));
    }

    @Test
    void contains() {
        HashTable<Allocation> table = new HashTable<>();
        Allocation alloc1 = new Allocation(1024, 1024);
        table.add(alloc1);
        assertTrue(table.contains(alloc1));
    }

    @Test
    void remove() {
        HashTable<Allocation> table = new HashTable<>();
        for (int i = 0; i < 10; i++) {
            table.add(new Allocation((1000) * (i + 1), 1024));
        }
        table.remove(new Allocation(10000, 2048));
        assertEquals("HashTable{table=[Node{data=Allocation{startAddress=9000, capacity=1024}\n" +
                "next=Node{data=Allocation{startAddress=8000, capacity=1024}\n" +
                "next=Node{data=Allocation{startAddress=7000, capacity=1024}\n" +
                "next=Node{data=Allocation{startAddress=6000, capacity=1024}\n" +
                "next=Node{data=Allocation{startAddress=5000, capacity=1024}\n" +
                "next=Node{data=Allocation{startAddress=4000, capacity=1024}\n" +
                "next=Node{data=Allocation{startAddress=3000, capacity=1024}\n" +
                "next=Node{data=Allocation{startAddress=2000, capacity=1024}\n" +
                "next=Node{data=Allocation{startAddress=1000, capacity=1024}\n" +
                "next=null}}}}}}}}}, null, null, null, null, null, null, null, null, null], size=10}", table.toString());
    }

}