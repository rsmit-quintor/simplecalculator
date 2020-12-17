package nl.ruben.simplecalculator.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        double result = calculatorService.add(999, 4);
        assertEquals(1003, result);
    }

    @Test
    void subtract() {
        double result = calculatorService.subtract(10005, 8);
        assertEquals(9997, result);
    }

    @Test
    void multiply() {
        double result = calculatorService.multiply(619, 971);
        assertEquals(601049, result);
    }

    @Test
    void divide() {
        double result = calculatorService.divide(999, 4);
        assertEquals(249.75, result);
    }
}