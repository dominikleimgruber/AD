package ch.hslu.ad.sw03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinarySearchTree<T extends Comparable> implements Tree<T> {

    private class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(final E data) {
            this.data = data;
        }
    }

    private static final Logger LOG = LogManager.getLogger(BinarySearchTree.class);
    private Node<T> root;
    private int size;

    @Override
    public boolean add(T element) {

        if (element == null) {
            return false;
        }

        if (root == null) {
            root = new Node(element);
            size++;
            return true;
        }

        Node<T> node = search(element);
        if (element.equals(node.data)) {
            return false;
        }

        if (node.data.compareTo(element) > 0) {
            node.left = new Node(element);
        } else if (node.data.compareTo(element) < 0) {
            node.right = new Node(element);
        } else {

            while (node.left != null && node.left.data.compareTo(element) == 0) {
                node = node.left;
            }
            Node<T> newNode = new Node(element);
            newNode.left = node.left;
            node.left = newNode;
        }
        size++;
        return true;

    }


    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(T element) {
        if (root == null) {
            return false;
        }

        Node<T> node = search(element);
        while (node.left != null && !(node.data.equals(element))) {
            node = node.left;
        }
        return element.equals(node.data);
    }


    public int size() {
        return size;
    }

    public void inorder(){
        inorder(root);
    }
    private void inorder(Node<T> node){
        if(node != null){
            inorder(node.left);
            LOG.info(node.data);
            inorder(node.right);
        }
    }

    private Node<T> search(final T element) {
        Node<T> parent;
        Node<T> child = root;

        do {
            parent = child;
            if (child.data.compareTo(element) > 0) {
                child = child.left;
            } else if (child.data.compareTo(element) < 0) {
                child = child.right;
            } else {
                return child;
            }
        } while (child != null);
        return parent;
    }
}
