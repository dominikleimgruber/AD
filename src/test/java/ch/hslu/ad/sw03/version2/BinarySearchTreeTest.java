package ch.hslu.ad.sw03.version2;

import ch.hslu.ad.sw03.version1.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void testAdd() {
        ch.hslu.ad.sw03.version1.BinarySearchTree<String> tree = new ch.hslu.ad.sw03.version1.BinarySearchTree<>();
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
        ch.hslu.ad.sw03.version1.BinarySearchTree<String> tree = new ch.hslu.ad.sw03.version1.BinarySearchTree<>();
        tree.add("G");
        tree.add("E");
        tree.add("F");
        tree.add("B");
        tree.add("A");
        tree.clear();
        assertEquals(0, tree.getSize());
    }

    @Test
    void testInorder(){
        ch.hslu.ad.sw03.version1.BinarySearchTree<String> tree = new ch.hslu.ad.sw03.version1.BinarySearchTree<>();
        tree.travers();
    }

    @Test
    void testContains() {
        ch.hslu.ad.sw03.version1.BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("G");
        tree.add("E");
        tree.add("F");
        tree.add("B");
        tree.add("A");
        tree.add("D");
        tree.add("C");
        tree.add("J");
        tree.add("H");
        tree.add("K");
        tree.add("I");
        assertEquals(true, tree.contains("C"));
    }
}