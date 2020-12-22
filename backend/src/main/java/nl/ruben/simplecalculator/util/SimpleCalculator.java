package nl.ruben.simplecalculator.util;

import nl.ruben.simplecalculator.dto.CalculationDto;

public final class SimpleCalculator {

    /** Calculates the outcome of adding
     * @param left left integer value
     * @param right right integer value
     * @return outcome as a double value
     */
    public static double add(int left, int right){
        return left + right;
    }

    /** Calculates the outcome of subtracting
     * @param left left integer value
     * @param right right integer value
     * @return outcome as a double value
     */
    public static double subtract(int left, int right){
        return left - right;
    }

    /** Calculates the outcome of multiplying
     * @param left left integer value
     * @param right right integer value
     * @return outcome as a double value
     */
    public static double multiply(int left, int right){
        return left * right;
    }

    /** Calculates the outcome of dividing
     * @param left left integer value
     * @param right right integer value
     * @return outcome as a double value
     */
    public static double divide(int left, int right){
        return (double)left / right;
    }
}
