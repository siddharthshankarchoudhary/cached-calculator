package io.github.siddharthshankarchoudhary.cachedcalculator.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;

@RequestScope
@Component
public class CalculatorCache {
    HashMap<String, Double> calculatedCache = new HashMap<>();
}
