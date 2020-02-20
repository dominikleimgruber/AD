package ch.hslu.ad.sw01.part1;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllocationTest {

    @Test
    void testHashCode() {
        assertEquals(true, new Allocation(0, 1024).hashCode() == new Allocation(0,1024).hashCode());
    }

    @Test
    void testEqualsNull() {
        assertEquals(false, new Allocation(0, 1024).equals(null));
    }
    @Test
    void testEqualsTrue() {
        assertEquals(true, new Allocation(0, 1024).equals(new Allocation(0, 1024)));
    }

    @Test
    void testEqualsFalse() {
        assertEquals(false, new Allocation(0, 1024).equals(new Allocation(1024, 2048)));
    }

    @Test
    void compareToBigger() {
        Allocation allocation1 = new Allocation(0, 1024);
        Allocation allocation2 = new Allocation(1024, 1024);
        assertEquals(true, allocation1.compareTo(allocation2) < 0);

    }

    @Test
    void compareToLess() {
        Allocation allocation1 = new Allocation(2048, 1024);
        Allocation allocation2 = new Allocation(1024, 1024);
        assertEquals(true, allocation1.compareTo(allocation2) > 0);

    }


    @Test
    void testEqualsVerifier() {
        EqualsVerifier.forClass(Allocation.class).verify();
    }
}