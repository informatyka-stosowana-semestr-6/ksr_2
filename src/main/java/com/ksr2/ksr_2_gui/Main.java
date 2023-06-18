package com.ksr2.ksr_2_gui;

import com.ksr2.ksr_2_gui.logic.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Initialize
        Initializer initializer = new Initializer();
        List<LinguisticVariable> linguisticVariables = initializer.createLinguisticVariable();
        List<House> houses = initializer.getAllHouses();
        List<Quantifier> quantifiers = initializer.createQuantifiers();

        // Getters from GUI
        List<Label> summarizers = new ArrayList<>();
        List<Double> measuresWeights = new ArrayList<>();
        // TODO get qualifiers from gui
        //////////////////////////////////
        // DEBUG
        //////////////////////////////////
        summarizers.add(linguisticVariables.get(1).getLabels().get(1));
        //////////////////////////////////


        // prepare summaries
        Summary summary = new Summary(houses, quantifiers);
        summary.createSummaries(summarizers);
        Measures measures = new Measures(measuresWeights);
        measures.calculateMeasures();

        // Show on gui
        List<String> generatedSummaries = summary.getSummaries();
        for (String generatedSummary :generatedSummaries) {
            System.out.println(generatedSummary);
        }
        // TODO getters for all measures T1-T11
    }
}
