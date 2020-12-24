package nl.ruben.simplecalculator.model;

import nl.ruben.simplecalculator.OperationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {

    @Test
    void calculateOutcome() {
        Calculation calculation = new Calculation(13, 17, OperationType.ADD);
        Double outcome = calculation.calculateOutcome();
        assertEquals(30, outcome);
        assertEquals(30, calculation.getOutcome());

        calculation.setOperation(OperationType.SUBTRACT);
        outcome = calculation.calculateOutcome();
        assertEquals(-4, outcome);
        assertEquals(-4, calculation.getOutcome());

        calculation.setOperation(OperationType.MULTIPLY);
        outcome = calculation.calculateOutcome();
        assertEquals(221, outcome);
        assertEquals(221, calculation.getOutcome());

        calculation.setOperation(OperationType.DIVIDE);
        outcome = calculation.calculateOutcome();
        assertEquals(0.7647058823529411, outcome);
        assertEquals(0.7647058823529411, calculation.getOutcome());
    }

    @Test
    void calculateOutcome_DivideByZero(){
        Calculation calculation = new Calculation(1, 0, OperationType.DIVIDE);
        assertThrows(ArithmeticException.class, calculation::calculateOutcome);
    }
}