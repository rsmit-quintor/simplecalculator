package nl.ruben.simplecalculator.service;

import nl.ruben.simplecalculator.OperationType;
import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.model.Calculation;
import nl.ruben.simplecalculator.repository.CalculationRepository;
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
class HistoryServiceTest {

    private CalculationRepository calculationRepository;
    private HistoryService historyService;

    @BeforeEach
    void setUp(@Mock CalculationRepository calculationRepository) {
        this.historyService = new HistoryService(calculationRepository);
        this.calculationRepository = calculationRepository;
    }

    @Test
    void getAllCalculations() {
        Calculation calculation = new Calculation();
        calculation.setLeft(999);
        calculation.setRight(4);
        calculation.setOperation(OperationType.ADD);
        calculation.setOutcome(1003.0);
        List<Calculation> calculationList = Collections.singletonList(calculation);
        Mockito.lenient()
                .when(calculationRepository.findAll())
                .thenReturn(calculationList);
        List<CalculationDto> result = historyService.getAllCalculations();
        verify(calculationRepository).findAll();
        CalculationDto resultDto = result.get(0);
        assertEquals(999, resultDto.getLeft());
        assertEquals(4, resultDto.getRight());
        assertEquals(1003.0, resultDto.getOutcome());
        assertEquals(OperationType.ADD, resultDto.getOperation());
    }
}