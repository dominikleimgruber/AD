package ch.hslu.ad.sw03.version4;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

/**
 * Klasse für eines simplen binären Suchbaumes, ohne Möglichlichkeit einzelne Elemente zu entfernen.
 *
 * @param <T> Generischer Datentyp, welcher in der Baumstruktur gespeichert wird.
 */


public class BinarySearchTree<T> implements Tree<T> {

    /**
     * Inner Node Klasse, in welcher die Datenobjekte gespeichert werden.
     *
     * @param <T> Generischer Datentyp, welcher in der Baumstruktur gespeichert wird.
     */
    private class Node<T> {
        private T data;
        private Node<T> parent;
        private Node<T> right;
        private Node<T> left;
        private int key;

        public Node(final T data, final Node<T> parent) {
            this.data = data;
            this.parent = parent;
            this.key = data.hashCode();
        }

        @Override
        public String toString() {
            return "Node{Data=" + data + "}";
        }
    }

    private final static Logger LOG = LogManager.getLogger(BinarySearchTree.class);

    private Node<T> root;
    private int size;
    private Comparator<T> comparator;


    public BinarySearchTree(final Comparator<T> comparator) {
        this.root = null;
        this.size = 0;
        this.comparator = comparator;
    }

    public BinarySearchTree() {
        this(null);
    }

    public int getSize() {
        return size;
    }


    /**
     * Hinzufügen eines Datenelements in der Datenstruktur. Ist ein Comparator vorhanden, so wird dieser zur Sortierung
     * verwendet, ansonsten der hashCode des Elements.
     *
     * @param element Zu speicherndes Element.
     * @return {@code true} oder {@code false} zu Überprüfung des Hinzufügeerfolges.
     */
    @Override
    public boolean add(final T element) {

        if (root == null) {
            root = new Node(element, null);
            size++;
            return true;
        }

        Node<T> node;

        if (comparator != null) {
            node = searchWithComparator(element);
            if (comparator.compare(node.data, element) > 0) {
                node.left = new Node(element, node);
                size++;
                return true;
            } else if (comparator.compare(node.data, element) < 0) {
                node.right = new Node(element, node);
                size++;
                return true;
            } else {
                return false;
            }
        }

        node = searchWithHash(element);
        if (node.key > element.hashCode()) {
            node.left = new Node(element, node);
            size++;
            return true;
        }
        if (node.key < element.hashCode()) {
            node.right = new Node(element, node);
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(final T element) {
        if (root == null) {
            return false;
        }

        Node<T> toRemove = searchWithHash(element);
        if (!(toRemove.data.equals(element))) {
            return false;
        }

        if (toRemove.left != null && toRemove.right != null) {
            return removeWithChildren(toRemove);
        }
        if (toRemove.left != null || toRemove.right != null) {
            return removeWithChild(toRemove);
        }

        if (root == toRemove) {
            root = null;
            size--;
            return true;
        }

        Node<T> parent = toRemove.parent;
        if (parent.key > toRemove.key) {
            parent.left = null;
        } else {
            parent.right = null;
        }
        size--;
        return true;
    }

    private boolean removeWithChild(Node<T> toRemove) {

        if (toRemove.left != null && toRemove.parent.left == toRemove) {
            toRemove.parent.left = toRemove.left;
            toRemove.left.parent = toRemove.parent;
        }
        if (toRemove.left != null && toRemove.parent.right == toRemove) {
            toRemove.parent.right = toRemove.left;
            toRemove.left.parent = toRemove.parent;
        }
        if (toRemove.right != null && toRemove.parent.left == toRemove) {
            toRemove.parent.left = toRemove.right;
            toRemove.right.parent = toRemove.parent;
        }
        if (toRemove.right != null && toRemove.parent.right == toRemove) {
            toRemove.parent.right = toRemove.right;
            toRemove.right.parent = toRemove.parent;
        }
        size--;
        return true;

    }

    private boolean removeWithChildren(Node<T> toRemove) {
        Node<T> replace = toRemove.right;
        if(replace.left == null){
            toRemove.right = replace.right;
            replace.right.parent = toRemove;
            toRemove.data = replace.data;
            toRemove.key = replace.key;
            size--;
            return true;
        }
        while (replace.left != null) {
            replace = replace.left;
        }
        replace.parent.left = replace.right;
        replace.right.parent = replace.parent;

        toRemove.data = replace.data;
        toRemove.key = replace.key;
        size--;
        return true;
    }

    /**
     * Löscht die komplette Datenstruktur.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }


    /**
     * Methode zur Überprüfung ob ein bestimmtes Element in der Datenstruktur vorhanden ist.
     *
     * @param element Zu überprüfendes Element.
     * @return {@code true} oder {@code false}
     */
    @Override
    public boolean contains(final T element) {
        if (root != null) {
            if (comparator != null) {
                return searchWithComparator(element).data.equals(element);
            } else {
                return searchWithHash(element).data.equals(element);
            }
        }
        return false;
    }


    private Node<T> searchWithComparator(final T element) {

        Node<T> parent = null;
        Node<T> child = root;
        int compare;

        while (child != null) {

            LOG.info(child);
            parent = child;
            compare = comparator.compare(child.data, element);
            if (compare > 0) {
                LOG.info("go left");
                child = child.left;
            } else if (compare < 0) {
                LOG.info("go right");
                child = child.right;
            } else {
                return child;
            }
        }
        return parent;
    }

    private Node<T> searchWithHash(final T element) {

        Node<T> parent = null;
        Node<T> child = root;
        final int identifier = element.hashCode();

        while (child != null) {
            parent = child;
            LOG.info(child);
            if (identifier < child.key) {
                LOG.info("go left");
                child = child.left;

            } else if (identifier > child.key) {
                LOG.info("go right");
                child = child.right;

            } else {
                return child;
            }
        }
        return parent;
    }

    public void travers() {
        LOG.info("inorder");
        inorder(root);
        LOG.info("postorder");
        postOrder(root);
        LOG.info("preorder");
        preOrder(root);
    }

    private void inorder(final Node<T> node) {
        if (node != null) {
            inorder(node.left);
            LOG.info(node);
            inorder(node.right);
        }
    }

    private void postOrder(final Node<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            LOG.info(node);
        }
    }

    private void preOrder(final Node<T> node) {
        if (node != null) {
            LOG.info(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}
