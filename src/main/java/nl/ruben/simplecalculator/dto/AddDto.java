package nl.ruben.simplecalculator.dto;

import lombok.Data;
import nl.ruben.simplecalculator.OperationType;

public class AddDto extends CalculationDto{
    OperationType operationType = OperationType.ADD;
}
