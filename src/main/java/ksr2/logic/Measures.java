package ksr2.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class Measures {
    private double[] weights;
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

    public Measures(double[] weights, List<Summary> summaries) {
        this.weights = weights;
        this.summaries = summaries;
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
}
