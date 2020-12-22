package nl.ruben.simplecalculator.rest;

import lombok.RequiredArgsConstructor;
import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
@CrossOrigin
public class HistoryController {
    @Autowired
    private final HistoryService historyService;

    /** Gets all calculations in the database
     * @return response with the calculations from the database
     */
    @GetMapping("")
    public ResponseEntity<List<CalculationDto>> getAllCalculations() {
       List<CalculationDto> calculationDtoList = historyService.getAllCalculations();

       return ResponseEntity.ok(calculationDtoList);
    }
}
