package com.ksr2.ksr_2_gui.logic.membershipFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MembershipFunctionFactory {
    public static MembershipFunction createObject(String membershipFunctionName, List<Double> variableValues) {
        return switch (membershipFunctionName) {
            case "Trapezoidal" -> new Trapezoidal(variableValues.get(0), variableValues.get(1), variableValues.get(2), variableValues.get(3));
            case "Gaussian" -> new Gaussian(variableValues.get(0), variableValues.get(1));
            case "Triangular" -> new Triangular(variableValues.get(0), variableValues.get(1), variableValues.get(2));
            default ->  throw new NoSuchElementException("No membership function: " + membershipFunctionName);
        };
    }
}