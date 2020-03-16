package ch.hslu.ad.sw03;

import ch.hslu.ad.sw01.part1.Allocation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeTest {


    BinarySearchTree createTree() {
        BinarySearchTree<Allocation> tree = new BinarySearchTree<>();
        tree.add(new Allocation(1024, 8192));
        tree.add(new Allocation(2048, 10240));
        tree.add(new Allocation(3072, 9216));
        tree.add(new Allocation(4096, 9216));
        tree.add(new Allocation(5120, 4096));
        tree.add(new Allocation(6144, 5120));
        tree.add(new Allocation(7168, 3072));
        return tree;
    }

    @Test
    void add() {
        BinarySearchTree<Allocation> tree = createTree();
        assertTrue(tree.add(new Allocation(16384, 1024)));
    }

    @Test
    void clear() {
        BinarySearchTree<Allocation> tree = createTree();
        tree.clear();
        assertEquals(0, tree.size());
    }

    @Test
    void contains() {
        BinarySearchTree<Allocation> tree = createTree();
        tree.inorder();
        assertTrue(tree.contains(new Allocation(4096, 9216)));
    }
}