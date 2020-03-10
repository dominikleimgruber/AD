package ch.hslu.ad.sw03.version3;

import ch.hslu.ad.sw01.part1.Allocation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySerchTreeTest {

    @Test
    void addWithCompare() {
        BinarySerchTree<Allocation> tree = new BinarySerchTree<>((alloc1, alloc2) -> alloc1.compareTo(alloc2));
        tree.add(new Allocation(8192, 1024));
        tree.add(new Allocation(4096, 1024));
        tree.add(new Allocation(5120, 1024));
        tree.add(new Allocation(2048, 1024));
        tree.add(new Allocation(3072, 1024));
        tree.add(new Allocation(1024, 1024));
        tree.add(new Allocation(11264, 1024));
        tree.add(new Allocation(9216, 1024));
        tree.add(new Allocation(10240, 1024));
        tree.add(new Allocation(16284, 1024));
        tree.add(new Allocation(1024, 1024));
        assertEquals(10, tree.getSize());
    }
    @Test
    void addWithHash() {
        BinarySerchTree<Allocation> tree = new BinarySerchTree<>();
        tree.add(new Allocation(8192, 1024)); //1
        tree.add(new Allocation(4096, 1024)); //2
        tree.add(new Allocation(5120, 1024)); //3
        tree.add(new Allocation(2048, 1024)); //4
        tree.add(new Allocation(3072, 1024)); //5
        tree.add(new Allocation(1024, 1024)); //6
        tree.add(new Allocation(11264, 1024)); //7
        tree.add(new Allocation(9216, 1024)); //8
        tree.add(new Allocation(10240, 1024)); //9
        tree.add(new Allocation(16284, 1024)); //10
        tree.add(new Allocation(1024, 1024)); //equal to 6 so should not be added
        assertEquals(10, tree.getSize());
    }

    @Test
    void clear() {
        BinarySerchTree<Allocation> tree = new BinarySerchTree<>((alloc1, alloc2) -> alloc1.compareTo(alloc2));
        tree.add(new Allocation(8192, 1024));
        tree.add(new Allocation(4096, 1024));
        tree.add(new Allocation(5120, 1024));
        tree.clear();
        assertEquals(0, tree.getSize());
    }

    @Test
    void contains() {
        BinarySerchTree<Allocation> tree = new BinarySerchTree<>((alloc1, alloc2) -> alloc1.compareTo(alloc2));
        tree.add(new Allocation(8192, 1024));
        tree.add(new Allocation(4096, 1024));
        tree.add(new Allocation(5120, 1024));
        tree.add(new Allocation(2048, 1024));
        tree.add(new Allocation(3072, 1024));
        tree.add(new Allocation(1024, 1024));
        tree.add(new Allocation(11264, 1024));
        Allocation alloc1 = new Allocation(9216, 1024);
        tree.add(alloc1);
        assertEquals(true, tree.contains(alloc1));
    }

    @Test
    void testTravers(){
        BinarySerchTree<Allocation> tree = new BinarySerchTree<>((alloc1, alloc2) -> alloc1.compareTo(alloc2));
        tree.add(new Allocation(8192, 1024));
        tree.add(new Allocation(4096, 1024));
        tree.add(new Allocation(5120, 1024));
        tree.add(new Allocation(2048, 1024));
        tree.add(new Allocation(3072, 1024));
        tree.add(new Allocation(1024, 1024));
        tree.add(new Allocation(11264, 1024));
        tree.add(new Allocation(9216, 1024));
        tree.travers();
    }
}