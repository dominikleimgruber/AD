package ch.hslu.ad.sw02.part2;

public class Node<T> {

    private Node<T> nextNode;
    private T element;

    public Node(T element, Node nextNode) {
        this.nextNode = nextNode;
        this.element = element;

    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public final  int hashCode() {
        return element.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Node)){
            return false;
        }

        Node<T> that = (Node) obj;
        return this.element.equals(that.getElement());

    }

    @Override
    public String toString() {
        return "Node[Element={" + element + "}";
    }
}
