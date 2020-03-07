package ch.hslu.ad.sw03.Tree;

public class Node<T> {

    private T data;
    private Node leftNode;
    private Node rightNode;
    private int key;

    public Node(T data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.key = data.hashCode();
    }

    public int getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{Data=" + data+ "}";
    }
}
