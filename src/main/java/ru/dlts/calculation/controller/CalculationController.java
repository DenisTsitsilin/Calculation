package ru.dlts.calculation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dlts.calculation.model.Calculation;
import ru.dlts.calculation.service.CalculationService;

import java.util.List;

@RestController
public class CalculationController {

    private final CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping(value = "/calculation")
    public ResponseEntity<?> create(@RequestBody Calculation calculation) {
        calculationService.create(calculation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping(value = "/calculation")
//    public ResponseEntity<List<Calculation>> read() {
//        final List<Calculation> calculations = calculationService.readAll();
//
//        return calculations != null &&  !calculations.isEmpty()
//                ? new ResponseEntity<>(calculations, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @GetMapping(value = "/calculation/{id}")
    public ResponseEntity<Calculation> read(@PathVariable(name = "id") int id) {
        final Calculation calculation = calculationService.read(id);

        return calculation != null
                ? new ResponseEntity<>(calculation, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/calculation/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Calculation calculation) {
        final boolean updated = calculationService.update(calculation, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/calculation/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = calculationService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/test")
    public ResponseEntity <Calculation> read() {
        Calculation calculation = new Calculation();
        calculation.setId(1);
        calculation.setCostImmovable(1500000.0);
        calculation.setCreditTerm(20.0);
        calculation.setInitialFee(400000.0);
        calculation.setPercent(7.9);

        return calculation != null
                ? new ResponseEntity<>(calculation, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
