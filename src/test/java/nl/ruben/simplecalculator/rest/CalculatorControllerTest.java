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

@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {

    private CalculatorController calculatorController;
    @BeforeEach
    void setUp(@Mock CalculatorService calculatorService) {
        calculatorController = new CalculatorController(calculatorService);
        Mockito.lenient()
                .when(calculatorService.add(any(CalculationDto.class)))
                    .thenReturn(9999.9999);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        CalculationDto dto = new CalculationDto();
        dto.setLeft(999);
        dto.setRight(4);
        ResponseEntity<Double> result = calculatorController.add(dto);
        assertEquals(9999.9999, result.getBody());
    }

    @Test
    void subtract() {
    }

    @Test
    void multiply() {
    }

    @Test
    void divide() {
    }
}