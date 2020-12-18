package nl.ruben.simplecalculator.dto;

import lombok.Data;

@Data
public class AnswerDto {
    private CalculationDto calculationDto;
    private Double outcome;
}
