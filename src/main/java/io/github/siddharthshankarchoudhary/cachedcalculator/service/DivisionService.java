package io.github.siddharthshankarchoudhary.cachedcalculator.service;

import io.github.siddharthshankarchoudhary.cachedcalculator.model.CalculatorCacheKey;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {
    private final CalculatorCache calculatorCache;

    DivisionService(CalculatorCache calculatorCache) {
        this.calculatorCache = calculatorCache;
    }

    private double divide(double num1, double num2) {
        return num1 / num2;
    }

    public double execute(double num1, double num2) {
        String cacheKey = String.format("%s %s %s", CalculatorCacheKey.DIVIDE, num1, num2);
        if(calculatorCache.calculatedCache.containsKey(cacheKey)) {
            return calculatorCache.calculatedCache.get(cacheKey);
        } else {
            double division = divide(num1, num2);
            calculatorCache.calculatedCache.put(cacheKey, division);
            return division;
        }
    }
}
