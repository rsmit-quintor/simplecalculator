package nl.ruben.simplecalculator.rest;

import nl.ruben.simplecalculator.dto.CalculationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Double> add(@RequestBody @Valid CalculationDto dto) {
        System.out.println("Received something to add");
        return ResponseEntity.ok((double) (dto.getLeft() + dto.getRight()));
    }

    @CrossOrigin
    @PostMapping("/subtract")
    public ResponseEntity<Double> subtract(@RequestBody @Valid CalculationDto dto) {
        System.out.println("Received something to subtract");
        return ResponseEntity.ok((double) (dto.getLeft() - dto.getRight()));
    }

    @CrossOrigin
    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody @Valid CalculationDto dto) {
        System.out.println("Received something to multiply");
        return ResponseEntity.ok((double) (dto.getLeft() * dto.getRight()));
    }

    @CrossOrigin
    @PostMapping("/divide")
    public ResponseEntity<Double> divide(@RequestBody @Valid CalculationDto dto) {
        System.out.println("Received something to divide");
        return ResponseEntity.ok((double) (dto.getLeft() / dto.getRight()));
    }
}
