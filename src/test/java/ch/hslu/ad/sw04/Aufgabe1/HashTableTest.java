package ch.hslu.ad.sw04.Aufgabe1;

import ch.hslu.ad.sw01.part1.Allocation;
import ch.hslu.ad.sw04.Aufgabe1.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    void add() {
        HashTable<Allocation> table = new HashTable<>();
        Allocation alloc1 = new Allocation(1024, 1024);
        table.add(alloc1);
        table.toString();
        assertEquals("HashTable{table=[null, null, null, null, Allocation{startAddress=1024, capacity=1024}," +
                " null, null, null, null, null], size=1}", table.toString());
    }

    @Test
    void addSameHash() {
        HashTable<Allocation> table = new HashTable<>();
        table.add(new Allocation(1024, 2048));
        Allocation alloc2 = new Allocation(1024, 1024);
        table.add(alloc2);
        table.toString();
        assertEquals("HashTable{table=[null, null, null, null, Allocation{startAddress=1024, capacity=2048}," +
                " null, null, null, null, null], size=1}", table.toString());
    }

    @Test
    void addWithNegativHash() {
        HashTable<Allocation> table = new HashTable<>();
        Allocation alloc1 = new Allocation(-1024, 2048);
        table.add(alloc1);
        table.toString();
        assertEquals("HashTable{table=[null, null, null, null, Allocation{startAddress=-1024, capacity=2048}," +
                " null, null, null, null, null], size=1}", table.toString());
    }

    @Test
    void addNull(){
        HashTable<Allocation> table = new HashTable<>();
        assertFalse(table.add(null));
    }

    @Test
    void contains() {

    }

    @Test
    void remove() {
        HashTable<Allocation> table = new HashTable<>();
        Allocation alloc1 = new Allocation(1024, 1024);
        table.add(alloc1);
        table.remove(alloc1);
        table.toString();
        assertEquals("HashTable{table=[null, null, null, null, null, null, " +
                "null, null, null, null], size=0}", table.toString());
    }
}