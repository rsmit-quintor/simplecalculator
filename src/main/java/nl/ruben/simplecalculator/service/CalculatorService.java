package nl.ruben.simplecalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double add(int left, int right){
        return left + right;
    }

    public double subtract(int left, int right){
        return left - right;
    }

    public double multiply(int left, int right){
        return left * right;
    }

    public double divide(int left, int right){
        return (double)left / right;
    }
}
