package ch.hslu.ad.sw01.part3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testFiboRec1Value1() {
        assertEquals(1, new Fibonacci().fiboRec1(1));
    }

    @Test
    void testFiboRec1Value0() {
        assertEquals(0, new Fibonacci().fiboRec1(0));
    }

    @Test
    void testFiboRec1ValueResonable(){
        assertEquals(55, new Fibonacci().fiboRec1(10));
    }

    @Test
    void testFiboItrReasonable(){
        assertEquals(55, new Fibonacci().fiboItr(10));
    }

}