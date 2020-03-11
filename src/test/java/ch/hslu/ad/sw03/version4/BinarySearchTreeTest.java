package ch.hslu.ad.sw03.version4;

import ch.hslu.ad.sw01.part1.Allocation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @Test
    void addWithCompare() {
        BinarySearchTree<Allocation> tree = new BinarySearchTree<>((alloc1, alloc2) -> alloc1.compareTo(alloc2));
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
        BinarySearchTree<Allocation> tree = new BinarySearchTree<>();
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
    void testRemoveWithNoChildren() {
        BinarySearchTree<Allocation> tree = new BinarySearchTree<>();
        tree.add(new Allocation(8192, 1024)); //1
        tree.add(new Allocation(4096, 1024)); //2
        tree.add(new Allocation(5120, 1024)); //3
        tree.add(new Allocation(2048, 1024)); //4
        tree.add(new Allocation(3072, 1024)); //5
        tree.add(new Allocation(1024, 1024)); //6
        tree.add(new Allocation(11264, 1024)); //7
        tree.add(new Allocation(9216, 1024)); //8
        tree.add(new Allocation(10240, 1024)); //9
        Allocation alloc1 = new Allocation(16284, 1024);
        tree.add(alloc1); //10
        tree.remove(alloc1);
        tree.travers();
        assertEquals(9, tree.getSize());
    }

    @Test
    void testRemoveWithRightChild() {
        BinarySearchTree<Allocation> tree = new BinarySearchTree<>();
        tree.add(new Allocation(8192, 1024)); //1
        tree.add(new Allocation(4096, 1024)); //2
        tree.add(new Allocation(5120, 1024)); //3
        tree.add(new Allocation(2048, 1024)); //4
        tree.add(new Allocation(3072, 1024)); //5
        tree.add(new Allocation(1024, 1024)); //6
        tree.add(new Allocation(11264, 1024)); //7
        Allocation alloc1 = new Allocation(9216, 1024);
        tree.add(alloc1); //8
        tree.add(new Allocation(10240, 1024)); //9
        tree.add(new Allocation(16284, 1024)); //10
        tree.remove(alloc1);
        tree.travers();
        assertEquals(9, tree.getSize());
    }

    @Test
    void testRemoveWithChildren() {
        BinarySearchTree<Allocation> tree = new BinarySearchTree<>();
        Allocation alloc1 = new Allocation(8192, 1024);
        tree.add(alloc1); //1
        tree.add(new Allocation(4096, 1024)); //2
        tree.add(new Allocation(5120, 1024)); //3
        tree.add(new Allocation(2048, 1024)); //4
        tree.add(new Allocation(3072, 1024)); //5
        tree.add(new Allocation(1024, 1024)); //6
        tree.add(new Allocation(11264, 1024)); //7
        tree.add(new Allocation(9216, 1024)); //8
        tree.add(new Allocation(10240, 1024)); //9
        tree.add(new Allocation(16284, 1024)); //10
        tree.remove(alloc1);
        tree.travers();
        assertEquals(9, tree.getSize());
    }


    @Test
    void clear() {
        BinarySearchTree<Allocation> tree = new BinarySearchTree<>((alloc1, alloc2) -> alloc1.compareTo(alloc2));
        tree.add(new Allocation(8192, 1024));
        tree.add(new Allocation(4096, 1024));
        tree.add(new Allocation(5120, 1024));
        tree.clear();
        assertEquals(0, tree.getSize());
    }

    @Test
    void contains() {
        BinarySearchTree<Allocation> tree = new BinarySearchTree<>((alloc1, alloc2) -> alloc1.compareTo(alloc2));
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
    void testTravers() {
        BinarySearchTree<Allocation> tree = new BinarySearchTree<>((alloc1, alloc2) -> alloc1.compareTo(alloc2));
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