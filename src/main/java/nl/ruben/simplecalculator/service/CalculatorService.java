package nl.ruben.simplecalculator.service;

import nl.ruben.simplecalculator.dto.CalculationDto;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

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
