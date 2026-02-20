package io.github.siddharthshankarchoudhary.cachedcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class SubtractionService {
    public double execute(double num1, double num2) {
        return num1 - num2;
    }
}
