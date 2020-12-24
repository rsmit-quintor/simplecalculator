package nl.ruben.simplecalculator.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void add() {
        Double result = SimpleCalculator.add(4, 9);
        assertEquals(13, result);
    }

    @Test
    void subtract() {
        Double result = SimpleCalculator.subtract(9, 4);
        assertEquals(5, result);
    }

    @Test
    void multiply() {
        Double result = SimpleCalculator.multiply(9, 4);
        assertEquals(36, result);
    }

    @Test
    void divide() {
        Double result = SimpleCalculator.divide(10, 4);
        assertEquals(2.5, result);
    }

    @Test
    void divide_DivideByZero() {
        assertThrows(ArithmeticException.class, () -> SimpleCalculator.divide(1, 0));
    }
}