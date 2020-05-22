package ch.hslu.ad.sw13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinitStateMachineTest {

    @Test
    void testIsWordLanguage() {

        assertEquals(true, FinitStateMachine.isWordLanguage("0111011101110"));
    }

    @Test
    void testIsWordLanguage2() {

        assertEquals(false, FinitStateMachine.isWordLanguage("1"));
    }

    @Test
    void testIsWordLanguage3() {

        assertEquals(true, FinitStateMachine.isWordLanguage("0"));
    }

    @Test
    void testIsWordLanguage4() {

        assertEquals(false, FinitStateMachine.isWordLanguage("011111001110"));
    }
}