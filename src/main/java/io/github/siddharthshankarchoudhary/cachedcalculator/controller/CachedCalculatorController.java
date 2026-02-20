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
    public CalculationResponse add(@RequestParam double num1, @RequestParam double num2) {
        double result = additionService.execute(num1, num2);
        return new CalculationResponse(num1, num2, result);
    }

    @GetMapping("/subtract")
    public CalculationResponse subtract(@RequestParam double num1, @RequestParam double num2) {
        double result = subtractionService.execute(num1, num2);
        return new CalculationResponse(num1, num2, result);
    }

    @GetMapping("/multiply")
    public CalculationResponse multiply(@RequestParam double num1, @RequestParam double num2) {
        double result = multiplicationService.execute(num1, num2);
        return new CalculationResponse(num1, num2, result);
    }

    @GetMapping("/divide")
    public CalculationResponse divide(@RequestParam double num1, @RequestParam double num2) {
        double result = divisionService.execute(num1, num2);
        return new CalculationResponse(num1, num2, result);
    }
}
