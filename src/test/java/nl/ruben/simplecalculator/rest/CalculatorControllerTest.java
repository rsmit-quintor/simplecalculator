package nl.ruben.simplecalculator.rest;

import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.service.CalculatorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {

    private CalculatorController calculatorController;
    private CalculatorService calculatorService;
    @BeforeEach
    void setUp(@Mock CalculatorService calculatorService) {
        calculatorController = new CalculatorController(calculatorService);
        this.calculatorService = calculatorService;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        Mockito.lenient()
                .when(calculatorService.add(any(CalculationDto.class)))
                .thenReturn(9999.9999);

        CalculationDto dto = new CalculationDto();
        dto.setLeft(999);
        dto.setRight(4);
        ResponseEntity<Double> result = calculatorController.add(dto);
        verify(calculatorService).add(dto);
        assertTrue(result.getStatusCode().is2xxSuccessful());
        assertEquals(9999.9999, result.getBody());
    }

    @Test
    void subtract() {
        Mockito.lenient()
                .when(calculatorService.subtract(any(CalculationDto.class)))
                .thenReturn(9999.9999);
        CalculationDto dto = new CalculationDto();
        dto.setLeft(999);
        dto.setRight(4);
        ResponseEntity<Double> result = calculatorController.subtract(dto);
        verify(calculatorService).subtract(dto);
        assertTrue(result.getStatusCode().is2xxSuccessful());
        assertEquals(9999.9999, result.getBody());
    }

    @Test
    void multiply() {
        Mockito.lenient()
                .when(calculatorService.multiply(any(CalculationDto.class)))
                .thenReturn(9999.9999);
        CalculationDto dto = new CalculationDto();
        dto.setLeft(999);
        dto.setRight(4);
        ResponseEntity<Double> result = calculatorController.multiply(dto);
        verify(calculatorService).multiply(dto);
        assertTrue(result.getStatusCode().is2xxSuccessful());
        assertEquals(9999.9999, result.getBody());
    }

    @Test
    void divide() {
        Mockito.lenient()
                .when(calculatorService.divide(any(CalculationDto.class)))
                .thenReturn(9999.9999);

        CalculationDto dto = new CalculationDto();
        dto.setLeft(999);
        dto.setRight(4);
        ResponseEntity<Double> result = calculatorController.divide(dto);
        verify(calculatorService).divide(dto);
        assertTrue(result.getStatusCode().is2xxSuccessful());
        assertEquals(9999.9999, result.getBody());
    }
}