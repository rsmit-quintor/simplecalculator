package nl.ruben.simplecalculator.mapper;

import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.model.Calculation;

public class CalculationMapper {
    public static CalculationDto toDto(Calculation calculation) {
        CalculationDto calculationDto = new CalculationDto();
        calculationDto.setLeft(calculation.getLeft());
        calculationDto.setRight(calculation.getRight());
        calculationDto.setOperation(calculation.getOperation());
        calculationDto.setOutcome(calculation.getOutcome());
        return calculationDto;
    }

    public static Calculation fromDto(CalculationDto calculationDto) {
        Calculation calculation = new Calculation();
        calculation.setLeft(calculationDto.getLeft());
        calculation.setRight(calculationDto.getRight());
        calculation.setOperation(calculationDto.getOperation());
        calculation.setOutcome(calculationDto.getOutcome());
        return calculation;
    }
}
