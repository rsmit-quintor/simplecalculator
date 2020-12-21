package nl.ruben.simplecalculator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.ruben.simplecalculator.OperationType;
import nl.ruben.simplecalculator.util.SimpleCalculator;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Calculation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Integer left;

    private Integer right;

    @Enumerated(EnumType.STRING)
    private OperationType operation;

    @NotNull
    private Double outcome;

    public Calculation(Integer left, Integer right, OperationType operationType) {
        this.left = left;
        this.right = right;
        this.operation = operationType;
    }

    public double calculateOutcome() {
        switch(operation) {
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
