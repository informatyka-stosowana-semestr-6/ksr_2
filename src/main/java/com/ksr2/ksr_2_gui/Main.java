package com.ksr2.ksr_2_gui;

import com.ksr2.ksr_2_gui.logic.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize
        Initializer initializer = new Initializer();
        List<LinguisticVariable> linguisticVariables = initializer.createLinguisticVariable();
        List<House> houses = initializer.getAllHouses();
        List<Quantifier> quantifiers = initializer.createQuantifiers();

        // Getters from GUI
        List<Label> qualifiers = new ArrayList<>();
        double[] measuresWeights = new double[0];
        // TODO get qualifiers from gui


        // prepare summaries
        Summary summary = new Summary(houses, quantifiers);
        summary.createSummaries(qualifiers);
        Measures measures = new Measures(measuresWeights);
        measures.calculateMeasures();

        // Show on gui
        List<String> generatedSummaries = summary.getSummaries();
        // TODO getters for all measures T1-T11
    }
}
