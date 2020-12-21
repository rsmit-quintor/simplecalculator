package nl.ruben.simplecalculator.service;

import lombok.RequiredArgsConstructor;
import nl.ruben.simplecalculator.dto.CalculationDto;
import nl.ruben.simplecalculator.mapper.CalculationMapper;
import nl.ruben.simplecalculator.model.Calculation;
import nl.ruben.simplecalculator.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    @Autowired
    private final CalculationRepository calculationRepository;

    public List<CalculationDto> getAllCalculations() {
        List<CalculationDto> calculationDtoList = new ArrayList<>();
        for (Calculation calculation : (Iterable<Calculation>) calculationRepository.findAll()) {
            calculationDtoList.add(
                    CalculationMapper.toDto(calculation)
            );
        }
        return calculationDtoList;
    }

}
