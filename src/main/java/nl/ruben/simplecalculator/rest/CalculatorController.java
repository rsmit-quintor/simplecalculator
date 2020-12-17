package nl.ruben.simplecalculator.rest;

import nl.ruben.simplecalculator.dto.AddDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Double> add(@RequestBody @Valid AddDto addDto) {
        System.out.println("Received something to add together");
        return ResponseEntity.ok((double) (addDto.getLeft() + addDto.getRight()));
    }
}
