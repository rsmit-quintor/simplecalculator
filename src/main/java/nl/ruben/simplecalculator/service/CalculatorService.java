package nl.ruben.simplecalculator.service;

import nl.ruben.simplecalculator.dto.AnswerDto;
import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.model.Calculation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CalculatorService {

    public List<AnswerDto> calculate(List<CalculationDto> dtoList) {
        Function<CalculationDto, AnswerDto> createAnswerDto = (CalculationDto dto) -> {
            AnswerDto answerDto = new AnswerDto();
            Double outcome = new Calculation(dto.getLeft(), dto.getRight(), dto.getOperationType())
                    .calculateOutcome();
            answerDto.setOutcome(outcome);
            answerDto.setCalculationDto(dto);
            return answerDto;
        };
        return dtoList.stream().map(createAnswerDto).collect(Collectors.toList());
    }

    public double add(CalculationDto dto){
        int left = dto.getLeft();
        int right = dto.getRight();
        return left + right;
    }

    public double subtract(CalculationDto dto){
        int left = dto.getLeft();
        int right = dto.getRight();
        return left - right;
    }

    public double multiply(CalculationDto dto){
        int left = dto.getLeft();
        int right = dto.getRight();
        return left * right;
    }

    public double divide(CalculationDto dto){
        double left = dto.getLeft();
        double right = dto.getRight();
        return left / right;
    }

}
