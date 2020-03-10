package ch.hslu.ad.sw03.version2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class BinarySearchTree<T> implements Tree<T> {

    private Node<T> root;
    private int size;
    private final static Logger LOG = LogManager.getLogger(BinarySearchTree.class);


    private final class Node<T> {

        private T data;
        private Node<T> left;
        private Node<T> right;
        private int key;

        private Node(T data) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.key = data.hashCode();
        }


        @Override
        public String toString() {
            return "Node{Data=" + data + "}";
        }

    }


    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }


    public int getSize() {
        return size;
    }

    public void travers() {
        inorder(root);
    }

    @Override
    public boolean add(T element) {
        if (root == null) {
            root = new Node(element);
            size++;
            return true;
        }

        Node child = root;
        Node parent;
        int identifier = element.hashCode();


        do {
            parent = child;
            if (identifier < child.key) {
                child = child.left;
            } else if (identifier > child.key) {
                child = child.right;
            } else {
                return false;
            }

        } while (child != null);

        Node node = new Node(element);
        if (identifier < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        size++;
        return true;
    }

    @Override
    public void clear() {
        root = null;
        this.size = 0;
    }

    @Override
    public boolean contains(T element) {

        int identifier = element.hashCode();
        Node temp = root;

        while (temp != null) {
            LOG.info(temp);
            if (identifier < temp.key) {
                LOG.info("go left");
                temp = temp.left;

            } else if (identifier > temp.key) {
                LOG.info("go right");
                temp = temp.right;

            } else{

                return identifier == temp.key && element.equals(temp.data);
            }
        }

        return false;
    }

    private void inorder(Node x) {
        if (x != null) { // Rekursionsbasis
            inorder(x.left);
            LOG.info(x.data);
            inorder(x.right);
        }
    }

}
