package nl.ruben.simplecalculator.service;

import nl.ruben.simplecalculator.dto.CalculationDto;
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
        CalculationDto dto = new CalculationDto();
        dto.setLeft(999);
        dto.setRight(4);
        double result = calculatorService.add(dto);
        assertEquals(1003, result);
    }

    @Test
    void subtract() {
        CalculationDto dto = new CalculationDto();
        dto.setLeft(10005);
        dto.setRight(8);
        double result = calculatorService.subtract(dto);
        assertEquals(9997, result);
    }

    @Test
    void multiply() {
        CalculationDto dto = new CalculationDto();
        dto.setLeft(619);
        dto.setRight(971);
        double result = calculatorService.multiply(dto);
        assertEquals(601049, result);
    }

    @Test
    void divide() {
        CalculationDto dto = new CalculationDto();
        dto.setLeft(999);
        dto.setRight(4);
        double result = calculatorService.divide(dto);
        assertEquals(249.75, result);
    }
}