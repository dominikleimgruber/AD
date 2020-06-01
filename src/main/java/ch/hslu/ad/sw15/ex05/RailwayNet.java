package ch.hslu.ad.sw15.ex05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RailwayNet {

    private final Map<Node, Set<Node>> map;

    public RailwayNet() {
        this.map = new HashMap<>();
    }

    public boolean isNodeInGraph(final Node node) {
        return map.containsKey(node);
    }

    public boolean addNode(final Node node) {
        if (!isNodeInGraph(node)) {
            map.put(node, new HashSet<>());
            return true;
        }
        return false;
    }

    public boolean removeNode(final Node toremove) {
        if (isNodeInGraph(toremove)) {
            map.remove(toremove);
            map.forEach((key, set) -> set.remove(toremove));
            return true;
        }
        return false;
    }

    public boolean isEdgeInGraph(final Node from, final Node to) {
        if (isNodeInGraph(from)) {
            return map.get(from).contains(to);
        }
        return false;
    }

    public boolean addEdge(final Node from, final Node to, final int value) {
        if (isNodeInGraph(from) && isNodeInGraph(to)) {
            if (!isEdgeInGraph(from, to)) {

                map.get(from).add(new Node(to.getName(), value));
                map.get(to).add(new Node(from.getName(), value));
                return true;
            }
        }
        return false;
    }

    public boolean removeEdge(final Node from, final Node to) {
        if (isEdgeInGraph(from, to)) {
            map.get(from).remove(to);
            map.get(to).remove(from);
            return true;
        }
        return false;

    }

    public int getEdgeValue(final Node from, final Node to) {
        if (isEdgeInGraph(from, to)) {
            for (Node n : map.get(from)) {
                if (n.equals(to)) {
                    return n.getValue();
                }
            }
        }
        throw new IllegalArgumentException("Edge is not given");
    }

    public int getNoOfNodes() {
        return map.size();
    }


    public Set<Node> getAllAdjaNodes(final Node node) {
        if (isNodeInGraph(node)) {
            return map.get(node);
        }
        return new HashSet<>();
    }

}
