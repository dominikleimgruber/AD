package ch.hslu.ad.sw03.Tree;

import ch.hslu.ad.sw03.version1.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void testAdd() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("G"); //1
        tree.add("E"); //2
        tree.add("F"); //3
        tree.add("B"); //4
        tree.add("A"); //5
        tree.add("D"); //6
        assertEquals(6, tree.getSize());

    }

    @Test
    void testClear() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("G");
        tree.add("E");
        tree.add("F");
        tree.add("B");
        tree.add("A");
        tree.clear();
        assertEquals(0, tree.getSize());
    }

    @Test
    void testTravers(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(6);
        tree.add(10);
        tree.add(12);
        tree.add(11);
        tree.add(4);
        tree.add(5);
        tree.add(2);
        tree.add(3);
        tree.add(1);
        tree.add(-1);

        tree.travers();
    }

    @Test
    void testContains() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(6);
        tree.add(10);
        tree.add(12);
        tree.add(11);
        tree.add(4);
        tree.add(5);
        tree.add(2);
        tree.add(3);
        tree.add(1);
        tree.add(-1);

        assertEquals(true, tree.contains(11));
    }

}