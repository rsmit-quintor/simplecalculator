package nl.ruben.simplecalculator.mapper;

import nl.ruben.simplecalculator.OperationType;
import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.model.Calculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationMapperTest {

    @Test
    void toDto() {
        Calculation calculation = new Calculation();
        calculation.setLeft(123);
        calculation.setRight(456);
        calculation.setOperation(OperationType.ADD);
        calculation.setOutcome(999999.99);

        CalculationDto dto = CalculationMapper.toDto(calculation);

        assertEquals(123, dto.getLeft());
        assertEquals(456, dto.getRight());
        assertEquals(OperationType.ADD, dto.getOperation());
        assertEquals(999999.99, dto.getOutcome());
    }

    @Test
    void fromDto() {

        CalculationDto calculationDto = new CalculationDto();
        calculationDto.setLeft(123);
        calculationDto.setRight(456);
        calculationDto.setOperation(OperationType.ADD);
        calculationDto.setOutcome(999999.99);

        Calculation calculation = CalculationMapper.fromDto(calculationDto);

        assertEquals(123, calculation.getLeft());
        assertEquals(456, calculation.getRight());
        assertEquals(OperationType.ADD, calculation.getOperation());
        assertEquals(999999.99, calculation.getOutcome());
    }
}