package io.github.siddharthshankarchoudhary.cachedcalculator.controller;

import io.github.siddharthshankarchoudhary.cachedcalculator.model.CalculationResponse;
import io.github.siddharthshankarchoudhary.cachedcalculator.service.AdditionService;
import io.github.siddharthshankarchoudhary.cachedcalculator.service.DivisionService;
import io.github.siddharthshankarchoudhary.cachedcalculator.service.MultiplicationService;
import io.github.siddharthshankarchoudhary.cachedcalculator.service.SubtractionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CachedCalculatorController {

    private final AdditionService additionService;
    private final SubtractionService subtractionService;
    private final MultiplicationService multiplicationService;
    private final DivisionService divisionService;

    public CachedCalculatorController(
            AdditionService additionService,
            MultiplicationService multiplicationService,
            DivisionService divisionService,
            SubtractionService subtractionService
    ) {
        this.additionService = additionService;
        this.multiplicationService = multiplicationService;
        this.divisionService = divisionService;
        this.subtractionService = subtractionService;
    }

    @GetMapping("/add")
    public CalculationResponse add(@RequestParam double a, @RequestParam double b) {
        double result = additionService.execute(a, b);
        return new CalculationResponse(a, b, result);
    }

    @GetMapping("/subtract")
    public CalculationResponse subtract(@RequestParam double a, @RequestParam double b) {
        double result = subtractionService.execute(a, b);
        return new CalculationResponse(a, b, result);
    }

    @GetMapping("/multiply")
    public CalculationResponse multiply(@RequestParam double a, @RequestParam double b) {
        double result = multiplicationService.execute(a, b);
        return new CalculationResponse(a, b, result);
    }

    @GetMapping("/divide")
    public CalculationResponse divide(@RequestParam double a, @RequestParam double b) {
        double result = divisionService.execute(a, b);
        return new CalculationResponse(a, b, result);
    }
}
