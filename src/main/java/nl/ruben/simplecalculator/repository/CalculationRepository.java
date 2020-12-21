package nl.ruben.simplecalculator.repository;

import nl.ruben.simplecalculator.model.Calculation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface CalculationRepository<T> extends CrudRepository<Calculation, Long> {

    @Override
    <S extends Calculation> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Iterable<Calculation> findAll();
}
