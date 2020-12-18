package nl.ruben.simplecalculator.rest;

import nl.ruben.simplecalculator.dto.AnswerDto;
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

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
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
    void calculate() {
        AnswerDto answerDto = new AnswerDto();
        CalculationDto dto = new CalculationDto();
        dto.setLeft(999);
        dto.setRight(4);
        answerDto.setCalculationDto(dto);
        answerDto.setOutcome(9999.9999);
        List<AnswerDto> answerDtoList = Collections.singletonList(answerDto);
        Mockito.lenient()
                .when(calculatorService.calculate(anyList()))
                .thenReturn(answerDtoList);

        List<CalculationDto> input = Collections.singletonList(dto);
        ResponseEntity<List<AnswerDto>> result = calculatorController.calculate(input);
        verify(calculatorService).calculate(input);
        assertTrue(result.getStatusCode().is2xxSuccessful());
        assertEquals(answerDtoList, result.getBody());
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