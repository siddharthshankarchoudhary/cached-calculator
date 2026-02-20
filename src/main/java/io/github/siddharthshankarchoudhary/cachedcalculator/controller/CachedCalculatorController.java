package io.github.siddharthshankarchoudhary.cachedcalculator.controller;

import io.github.siddharthshankarchoudhary.cachedcalculator.model.CalculationResponse;
import io.github.siddharthshankarchoudhary.cachedcalculator.service.AdditionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CachedCalculatorController {

    private final AdditionService additionService;

    public CachedCalculatorController(AdditionService additionService) {
        this.additionService = additionService;
    }

    @GetMapping("/add")
    public CalculationResponse add(@RequestParam double a, @RequestParam double b) {
        double result = additionService.execute(a, b);
        return new CalculationResponse(a, b, result);
    }
}
