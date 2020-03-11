package ch.hslu.ad.sw03.version3;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void addNullWithComp() {
        BinarySearchTree<String> tree = new BinarySearchTree<>((s1, s2) -> s1.compareTo(s2));
        assertEquals(false, tree.add(null));
    }
    @Test
    void addNullWithHash() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        assertEquals(false, tree.add(null));
    }

    @Test
    void addLeftAndRightWithComp() {
        BinarySearchTree<String> tree = new BinarySearchTree<>((s1, s2) -> s1.compareTo(s2));
        tree.add("G");
        tree.add("A");
        tree.add("X");
        assertEquals(3, tree.getSize());
        tree.inorder();
    }
    @Test
    void addLeftAndRightWithHash() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("G");
        tree.add("A");
        tree.add("X");
        assertEquals(3, tree.getSize());
        tree.inorder();
    }

    @Test
    void clear() {
        BinarySearchTree<String> tree = new BinarySearchTree<>((s1, s2) -> s1.compareTo(s2));
        tree.add("G");
        tree.add("A");
        tree.add("X");
        tree.clear();
        tree.inorder();
        assertEquals(0, tree.getSize());
    }

    @Test
    void containsWithComp() {
        BinarySearchTree<String> tree = new BinarySearchTree<>((s1, s2) -> s1.compareTo(s2));
        tree.add("G");
        tree.add("A");
        tree.add("X");
        assertEquals(true, tree.contains("X"));
    }

    @Test
    void containsWithHash() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("G");
        tree.add("A");
        tree.add("X");
        assertEquals(true, tree.contains("X"));
    }

    @Test
    void testContainsNull(){
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("G");
        tree.add("A");
        tree.add("X");
        assertEquals(false, tree.contains(null));
    }

    @Test
    void inorder() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.inorder();
    }

    @Test
    void preorder() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.preorder();
    }

    @Test
    void postorder() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.postorder();
    }
}