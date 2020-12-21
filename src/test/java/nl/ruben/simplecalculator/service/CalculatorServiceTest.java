package nl.ruben.simplecalculator.service;

import nl.ruben.simplecalculator.OperationType;
import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.model.Calculation;
import nl.ruben.simplecalculator.repository.CalculationRepository;
import nl.ruben.simplecalculator.rest.HistoryController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    private CalculationRepository calculationRepository;
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp(@Mock CalculationRepository calculationRepository) {
        this.calculatorService = new CalculatorService(calculationRepository);
        this.calculationRepository = calculationRepository;
    }

    @Test
    void calculate() {
        CalculationDto calculationDto = new CalculationDto();
        calculationDto.setLeft(999);
        calculationDto.setRight(4);
        calculationDto.setOperation(OperationType.ADD);
        List<CalculationDto> calculationDtoList = Collections.singletonList(calculationDto);
        Mockito.lenient()
                .when(calculationRepository.save(any(Calculation.class)))
                .thenReturn(new Calculation());
        List<CalculationDto> result = calculatorService.calculate(calculationDtoList);
        verify(calculationRepository).save(any(Calculation.class));
        CalculationDto resultDto = result.get(0);
        assertEquals(999, resultDto.getLeft());
        assertEquals(4, resultDto.getRight());
        assertEquals(1003, resultDto.getOutcome());
        assertEquals(OperationType.ADD, resultDto.getOperation());
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