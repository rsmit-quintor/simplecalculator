package nl.ruben.simplecalculator.dto;

import lombok.Data;
import nl.ruben.simplecalculator.OperationType;

@Data
public abstract class CalculationDto {
    private OperationType operationType;
    private int left;
    private int right;
}
