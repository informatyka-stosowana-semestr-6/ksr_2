package com.ksr2.ksr_2_gui.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class Measures {
    // TODO All of functions T1-T11

    private List<Double> weights;
    private List<Summary> summaries;
    private double T1degreeOfTruth = 0;
    private double T2degreeOfImprecision = 0;
    private double T3degreeOfCovering = 0;
    private double T4degreeOfAppropriateness = 0;
    private double T5lengthOfSummary = 0;
    private double T6degreeOfQuantifierImprecision = 0;
    private double T7degreeOfQuantifierCardinality = 0;
    private double T8degreeOfSummarizerCardinality = 0;
    private double T9degreeOfQualifierImprecision = 0;
    private double T10degreeOfQualifierCardinality = 0;
    private double T11lengthOfQualifier = 0;
    private double goodnessOfSummary = 0;
    private List<Runnable> functions = List.of(this::calculateT1,
                                               this::calculateT2, this::calculateT3,
                                               this::calculateT4, this::calculateT5,
                                               this::calculateT6, this::calculateT7,
                                               this::calculateT8, this::calculateT9,
                                               this::calculateT10, this::calculateT11);

    public Measures(List<Double> weights, List<Summary> summaries) {
        this.weights = weights;
        this.summaries = summaries;
    }

    public Measures(List<Double> weights) {
        this.weights = weights;
    }

    private void calculateT1() {
    }

    private void calculateT2() {
//        TODO
        this.T2degreeOfImprecision = 0;
    }

    private void calculateT3() {
    }

    private void calculateT4() {
    }

    private void calculateT5() {
    }

    private void calculateT6() {
    }

    private void calculateT7() {
    }

    private void calculateT8() {
    }

    private void calculateT9() {
    }

    private void calculateT10() {
    }

    private void calculateT11() {
    }

    public void calculateMeasures() {
        for (Runnable function : this.functions) {
            function.run();
        }
    }

    public double getT1degreeOfTruth() {
        return T1degreeOfTruth;
    }

    public double getT2degreeOfImprecision() {
        return T2degreeOfImprecision;
    }

    public double getT3degreeOfCovering() {
        return T3degreeOfCovering;
    }

    public double getT4degreeOfAppropriateness() {
        return T4degreeOfAppropriateness;
    }

    public double getT5lengthOfSummary() {
        return T5lengthOfSummary;
    }

    public double getT6degreeOfQuantifierImprecision() {
        return T6degreeOfQuantifierImprecision;
    }

    public double getT7degreeOfQuantifierCardinality() {
        return T7degreeOfQuantifierCardinality;
    }

    public double getT8degreeOfSummarizerCardinality() {
        return T8degreeOfSummarizerCardinality;
    }

    public double getT9degreeOfQualifierImprecision() {
        return T9degreeOfQualifierImprecision;
    }

    public double getT10degreeOfQualifierCardinality() {
        return T10degreeOfQualifierCardinality;
    }

    public double getT11lengthOfQualifier() {
        return T11lengthOfQualifier;
    }
}
