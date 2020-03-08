package ch.hslu.ad.sw03.version1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinarySearchTree<T> implements Tree<T> {

    private Node<T> root;
    private int size;
    private final static Logger LOG = LogManager.getLogger(BinarySearchTree.class);

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
            root = new Node(element, null, null);
            size++;
            return true;
        }

        Node child = root;
        Node parent = child;
        int identifier = element.hashCode();
        int key = 0;

        do {
            parent = child;
            key = child.getKey();

            if (identifier < key) {
                child = child.getLeftNode();
            } else if (identifier > child.getKey()) {
                child = child.getRightNode();
            } else {
                return false;
            }

        } while (child != null);

        Node node = new Node(element, null, null);
        if (identifier < key) {
            parent.setLeftNode(node);
        } else {
            parent.setRightNode(node);
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
            if (identifier < temp.getKey()) {
                LOG.info("go left");
                temp = temp.getLeftNode();

            } else if (identifier > temp.getKey()) {
                LOG.info("go right");
                temp = temp.getRightNode();

            } else {
                return identifier == temp.getKey() && element.equals(temp.getData());
            }
        }

        return false;
    }

    private void inorder(Node x) {
        if (x != null) { // Rekursionsbasis
            inorder(x.getLeftNode());
            LOG.info(x.getData());
            inorder(x.getRightNode());
        }
    }

}
