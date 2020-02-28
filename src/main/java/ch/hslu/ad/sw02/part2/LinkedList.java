package ch.hslu.ad.sw02.part2;

public class LinkedList<T> {
    private int size;
    private Node<T> head;

    public LinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T element) {

        head = new Node<T>(element, head);
        size++;
    }

    public boolean contains(T element) {
        Node<T> temp = head;
        while (temp.getNextNode() != null) {

            if (temp.getElement().equals(element)) {
                return true;
            }
            temp = temp.getNextNode();
        }
        return false;
    }

    public T getAndRemove(final int n) {

        T element = null;
        if (n <= size && n > 0) {
            Node<T> temp = head;
            for (int i = 1; i < n; i++) {
                temp = temp.getNextNode();
            }

            element = temp.getNextNode().getElement();

            if (size != n) {
                temp.setNextNode(temp.getNextNode().getNextNode());
            } else {
                temp.setNextNode(null);
            }

        } else if (n == 0) {
            element = head.getElement();
            head = head.getNextNode();
        }
        return element;
    }

    public ListIterator<T> iterator(){
        return new ListIterator<>(head);
    }
}


