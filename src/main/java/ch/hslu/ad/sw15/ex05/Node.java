package ch.hslu.ad.sw15.ex05;

import java.util.Objects;

public class Node {
    private final String name;
    private final int value;
    private Color color;

    public Node(final String name, final int value) {
        this.name = name;
        this.color = Color.WHITE;
        this.value = value;
    }

    public Node(String name) {
        this(name, Integer.MAX_VALUE);
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }

        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
