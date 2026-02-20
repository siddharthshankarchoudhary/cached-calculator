package io.github.siddharthshankarchoudhary.cachedcalculator.service;

import io.github.siddharthshankarchoudhary.cachedcalculator.model.CalculatorCacheKey;
import org.springframework.stereotype.Service;

@Service
public class AdditionService {
    private final CalculatorCache calculatorCache;

    AdditionService(CalculatorCache calculatorCache) {
        this.calculatorCache = calculatorCache;
    }

    private double add(double num1, double num2) {
        return num1 + num2;
    }

    public double execute(double num1, double num2) {
        String cacheKey = String.format("%s %s %s", CalculatorCacheKey.ADD, num1, num2);
        if(calculatorCache.containsKey(cacheKey)) {
            double cachedValue = calculatorCache.get(cacheKey);
            System.out.println("Cached value is : " + cachedValue);
            return cachedValue;
        } else {
            double sum = add(num1, num2);
            System.out.println("Calculated value is : " + sum);
            calculatorCache.put(cacheKey, sum);
            return sum;
        }
    }
}
