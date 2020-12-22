package nl.ruben.simplecalculator.service;

import lombok.RequiredArgsConstructor;
import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.model.Calculation;
import nl.ruben.simplecalculator.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    @Autowired
    private final CalculationRepository calculationRepository;

    /**
     * Calculates the input and saves the calculation, then it gives the calculation back with outcomes
     * @param dtoList a list of CalculationDtos
     * @return result of the calculation as a list
     */
    public List<CalculationDto> calculate(List<CalculationDto> dtoList) {
        Function<CalculationDto, CalculationDto> calculateAndSave = (CalculationDto dto) -> {
            Calculation calculation = new Calculation(dto.getLeft(), dto.getRight(), dto.getOperation());
            Double outcome = calculation.calculateOutcome();
            calculationRepository.save(calculation);
            dto.setOutcome(outcome);
            return dto;
        };
        return dtoList.stream().map(calculateAndSave).collect(Collectors.toList());
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
