package ch.hslu.ad.sw15.ex05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RailwayNetTest {

    private RailwayNet railway;

    @BeforeEach
    void setup() {
        String[] cities = new String[]{"Olten", "Aarau", "Brugg", "Lenzburg", "Zofingen"};
        this.railway = new RailwayNet();
        for (String city : cities) {
            this.railway.addNode(new Node(city));
        }
        this.railway.addEdge(new Node("Olten"), new Node("Aarau"), 13);
        this.railway.addEdge(new Node("Olten"), new Node("Zofingen"), 7);
        this.railway.addEdge(new Node("Aarau"), new Node("Brugg"), 13);
        this.railway.addEdge(new Node("Aarau"), new Node("Lenzburg"), 8);
        this.railway.addEdge(new Node("Brugg"), new Node("Lenzburg"), 13);
        this.railway.addEdge(new Node("Zofingen"), new Node("Lenzburg"), 13);
    }

    @Test
    void testIsNodeInGraph() {
        assertTrue(this.railway.isNodeInGraph(new Node("Olten")));
    }

    @Test
    void testRemoveNode() {

        this.railway.removeNode(new Node("Olten"));
        assertFalse(railway.isNodeInGraph(new Node("Olten")));
        assertFalse(railway.isEdgeInGraph(new Node("Aarau"), new Node("Olten")));
    }

    @Test
    void testIsEdgeInGraph() {
        Node n;
        assertTrue(this.railway.isEdgeInGraph(new Node("Zofingen"), new Node("Lenzburg")));
    }

    @Test
    void testRemoveEdge() {
        Node n1 = new Node("Olten");
        Node n2 = new Node("Aarau");
        assertTrue(this.railway.removeEdge(n1, n2));
        assertFalse(this.railway.isEdgeInGraph(n1, n2));
    }

    @Test
    void testGetEdgeValue() {
        assertEquals(13, this.railway.getEdgeValue(new Node("Olten"), new Node("Aarau")));
    }

    @Test
    void testGetNoOfNodes() {
        assertEquals(5, railway.getNoOfNodes());
    }

    @Test
    void testGetAllAdjaNodes() {
        List<Node> set = new ArrayList<>(railway.getAllAdjaNodes(new Node("Brugg")));
        assertEquals(set.get(0), new Node("Aarau"));
        assertEquals(set.get(1), new Node("Lenzburg"));

    }
}