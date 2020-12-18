package nl.ruben.simplecalculator.model;

import lombok.RequiredArgsConstructor;
import nl.ruben.simplecalculator.OperationType;
import nl.ruben.simplecalculator.util.SimpleCalculator;

@RequiredArgsConstructor
public class Calculation {
    private final Integer left;
    private final Integer right;
    private final OperationType operationType;

    private Double outcome;

    public double calculateOutcome() {
        switch(operationType) {
            case ADD:
                outcome = SimpleCalculator.add(left, right);
                break;
            case SUBTRACT:
                outcome = SimpleCalculator.subtract(left, right);
                break;
            case MULTIPLY:
                outcome = SimpleCalculator.multiply(left, right);
                break;
            case DIVIDE:
                outcome = SimpleCalculator.divide(left, right);
                break;
            default:
                outcome = null;
        }
        return outcome;
    }
}
