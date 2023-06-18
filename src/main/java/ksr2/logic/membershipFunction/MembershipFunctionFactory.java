package ksr2.logic.membershipFunction;

import java.util.List;

public class MembershipFunctionFactory {
    public static MembershipFunction createObject(String membershipFunctionName, List<Double> variableValues) {
        if (membershipFunctionName.equals("Trapezoidal")) {
            return new Trapezoidal(variableValues.get(0), variableValues.get(1), variableValues.get(2), variableValues.get(3));
        }
        else {
//            TODO
            return null;
        }
    }
}
