package nl.ruben.simplecalculator.rest;

import lombok.RequiredArgsConstructor;
import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class CalculatorController {

    @Autowired
    private final CalculatorService calculatorService;

    @CrossOrigin
    @PostMapping("")
    public ResponseEntity<List<CalculationDto>> calculate(@RequestBody @Valid List<CalculationDto> dtoList) {
        List<CalculationDto> result = calculatorService.calculate(dtoList);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Double> add(@RequestBody @Valid CalculationDto dto) {
        System.out.println("Received something to add");
        double result = calculatorService.add(dto);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin
    @PostMapping("/subtract")
    public ResponseEntity<Double> subtract(@RequestBody @Valid CalculationDto dto) {
        System.out.println("Received something to subtract");
        double result = calculatorService.subtract(dto);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin
    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody @Valid CalculationDto dto) {
        System.out.println("Received something to multiply");
        double result = calculatorService.multiply(dto);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin
    @PostMapping("/divide")
    public ResponseEntity<Double> divide(@RequestBody @Valid CalculationDto dto) {
        System.out.println("Received something to divide");
        double result = calculatorService.divide(dto);
        return ResponseEntity.ok(result);
    }
}
