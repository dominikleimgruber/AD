package ch.hslu.ad.sw01.part3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private static final Logger LOG = LogManager.getLogger(FibonacciTest.class);

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
        long startTime = System.currentTimeMillis();
        assertEquals(5, new Fibonacci().fiboRec1(5));
        LOG.info(System.currentTimeMillis() - startTime);
    }

    @Test
    void testFiboItrReasonable(){
        long startTime = System.currentTimeMillis();
        assertEquals(12586269025l, new Fibonacci().fiboItr(50));
        LOG.info(System.currentTimeMillis() - startTime);
    }

    @Test
    void testFiboItrZero(){
        assertEquals(0, new Fibonacci().fiboItr(0));
    }

    @Test
    void testFiboRec2(){
        assertEquals(55, new Fibonacci().fiboRec2(10));
    }

}