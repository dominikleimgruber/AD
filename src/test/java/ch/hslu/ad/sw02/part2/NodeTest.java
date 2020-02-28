package ch.hslu.ad.sw02.part2;

import ch.hslu.ad.sw01.part1.Allocation;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void getNextNode() {
        Node<Allocation> test = new Node<>(new Allocation(0, 1024), null);
        test.setNextNode(new Node<Allocation>(new Allocation( 1024, 1024), null));
        assertEquals(1024, test.getNextNode().getElement().getCapacity());

    }

    @Test
    void setElement() {
        Node<String> test = new Node<>("Test",null);
        test.setElement("test2");
        assertEquals("test2", test.getElement());
    }




}