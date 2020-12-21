package nl.ruben.simplecalculator.rest;

import nl.ruben.simplecalculator.OperationType;
import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.service.CalculatorService;
import nl.ruben.simplecalculator.service.HistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class HistoryControllerTest {

    private HistoryController historyController;
    private HistoryService historyService;

    @BeforeEach
    void setUp(@Mock HistoryService historyService) {
        historyController = new HistoryController(historyService);
        this.historyService = historyService;
    }

    @Test
    void getAllCalculations() {

        CalculationDto calculationDto = new CalculationDto();
        calculationDto.setLeft(999);
        calculationDto.setRight(4);
        calculationDto.setOperation(OperationType.ADD);
        calculationDto.setOutcome(9999.9999);
        List<CalculationDto> calculationDtoList = Collections.singletonList(calculationDto);
        Mockito.lenient()
                .when(historyService.getAllCalculations())
                .thenReturn(calculationDtoList);

        ResponseEntity<List<CalculationDto>> result = historyController.getAllCalculations();
        verify(historyService).getAllCalculations();
        assertTrue(result.getStatusCode().is2xxSuccessful());
        assertEquals(calculationDtoList, result.getBody());
    }
}