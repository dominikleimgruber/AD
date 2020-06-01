package ch.hslu.ad.sw15.ex04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RailwayNet1Test {

    private RailwayNet1 railway;

    @BeforeEach
    void setup() {
        this.railway = new RailwayNet1("Olten", "Aarau", "Brugg", "Lenzburg", "Zofingen");
        this.railway.addConnection("Olten", "Aarau", 13);
        this.railway.addConnection("Olten", "Zofingen", 7);
        this.railway.addConnection("Aarau", "Brugg", 13);
        this.railway.addConnection("Aarau", "Lenzburg", 8);
        this.railway.addConnection("Brugg", "Lenzburg", 16);
        this.railway.addConnection("Zofingen", "Lenzburg", 34);
    }

    @Test
    void testRemoveEdge() {
        railway.removeEdge("Brugg", "Lenzburg");
        assertEquals(Integer.MAX_VALUE, railway.getDuration("Brugg", "Lenzburg"));
    }

    @Test
    void testGetNodeName() {
        assertEquals("Olten", railway.getNodeName(0));
    }

    @Test
    void testGetDuration() {
        assertEquals(34, railway.getDuration("Zofingen", "Lenzburg"));
        assertEquals(34, railway.getDuration("Lenzburg", "Zofingen"));

    }

    @Test
    void testGetNoOfConnections() {
        assertEquals(6, railway.getNoOfConnections());
    }

    @Test
    void testGetNoOfNodes() {
        assertEquals(5, railway.getNoOfNodes());
    }

    @Test
    void testIsDirectEdgeTrue() {
        assertTrue(railway.isDirectEdge("Olten", "Aarau"));
    }

    @Test
    void testIsDirectEdgeFalse() {
        assertFalse(railway.isDirectEdge("Olten", "Lenzburg"));
    }

    @Test
    void testGetDirectConnectedNodes() {
        assertEquals(2, railway.getDirectConnectedNodes("Olten").size());
    }
}