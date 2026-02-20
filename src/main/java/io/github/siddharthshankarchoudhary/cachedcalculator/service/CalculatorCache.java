package io.github.siddharthshankarchoudhary.cachedcalculator.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import java.util.HashMap;

@RequestScope
@Component
public class CalculatorCache {
    private final HashMap<String, Double> calculatedCache = new HashMap<>();

    public boolean containsKey(String key) {
        return calculatedCache.containsKey(key);
    }

    public Double get(String key) {
        return calculatedCache.get(key);
    }

    public void put(String key, Double value) {
        calculatedCache.put(key, value);
    }
}
