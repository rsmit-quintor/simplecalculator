package nl.ruben.simplecalculator.util;

import nl.ruben.simplecalculator.dto.CalculationDto;

public final class SimpleCalculator {

    public static double add(int left, int right){
        return left + right;
    }

    public static double subtract(int left, int right){
        return left - right;
    }

    public static double multiply(int left, int right){
        return left * right;
    }

    public static double divide(int left, int right){
        return (double)left / right;
    }
}
