package ch.hslu.ad.sw03.version3;

import ch.hslu.ad.sw03.version2.BinarySearchTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

/**
 * Klasse für eines simplen binären Suchbaumes, ohne Möglichlichkeit einzelne Elemente zu entfernen.
 *
 * @param <T> Generischer Datentyp, welcher in der Baumstruktur gespeichert wird.
 */


public class BinarySerchTree<T> implements Tree<T> {

    /**
     * Inner Node Klasse, in welcher die Datenobjekte gespeichert werden.
     *
     * @param <T> Generischer Datentyp, welcher in der Baumstruktur gespeichert wird.
     */
    private class Node<T> {
        private T data;
        private Node<T> right;
        private Node<T> left;
        private int key;

        public Node(final T data) {
            this.data = data;
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


    public BinarySerchTree(final Comparator<T> comparator) {
        this.root = null;
        this.size = 0;
        this.comparator = comparator;
    }

    public BinarySerchTree() {
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
            root = new Node(element);
            size++;
            return true;
        }

        Node<T> node;

        if (comparator != null) {
            node = searchWithComparator(element);
            if (comparator.compare(node.data, element) > 0) {
                node.left = new Node(element);
                size++;
                return true;
            }

            if (comparator.compare(node.data, element) < 0) {
                node.right = new Node(element);
                size++;
                return true;
            }

        }

        node = searchWithHash(element);
        if (node.key > element.hashCode()) {
            node.left = new Node(element);
            size++;
            return true;
        }
        if (node.key < element.hashCode()) {
            node.right = new Node(element);
            size++;
            return true;
        }
        return false;
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
        int identifier = element.hashCode();

        while (child != null) {
            parent = child;
            LOG.info(child);
            if (identifier < child.key) {
                LOG.info("go left");
                child = child.left;

            } else if (identifier > child.key) {
                LOG.info("go right");
                child = child.right;

            } else if (element.equals(child.data)) {
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
