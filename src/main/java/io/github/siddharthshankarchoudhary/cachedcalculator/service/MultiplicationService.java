package io.github.siddharthshankarchoudhary.cachedcalculator.service;

import io.github.siddharthshankarchoudhary.cachedcalculator.model.CalculatorCacheKey;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {
    private final CalculatorCache calculatorCache;

    MultiplicationService(CalculatorCache calculatorCache) {
        this.calculatorCache = calculatorCache;
    }

    private double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double execute(double num1, double num2) {
        String cacheKey = String.format("%s %s %s", CalculatorCacheKey.MULTIPLY, num1, num2);
        if(calculatorCache.containsKey(cacheKey)) {
            return calculatorCache.get(cacheKey);
        } else {
            double multiplication = multiply(num1, num2);
            calculatorCache.put(cacheKey, multiplication);
            return multiplication;
        }
    }
}
