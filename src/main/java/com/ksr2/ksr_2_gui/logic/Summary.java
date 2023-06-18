package com.ksr2.ksr_2_gui.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Summary {
    // Both quantifiers
    List<Quantifier> quantifiers;
    // List of houses
    List<House> houses;
    // generated summaries
    private List<String> summaries = new ArrayList<>();
    // TODO zmienne które się łapią
    private final List<House> qualifiedHouses = new ArrayList<>();
    private int numberOfQualifiedHouses = 0;


    public Summary(List<House> houses, List<Quantifier> quantifiers) { // From database
        this.houses = houses;
        this.quantifiers = quantifiers;
    }

    public void createSummaries(List<Label> summarizers) {
//        private lista domów, potem przeiterować wszystkie i zliczać te które załapują się w kwantyfikator a następnie możemy dodać
//        te zmienne które wynikają z tych liczb
        for (House house : this.houses) {
            double membership = 0;
            for (Label summarizer : summarizers) {
                membership += summarizer.getMembership(house.getByName(this.getLinguisticVariableName(summarizer.getLabel())));
            }
            membership /= summarizers.size();  // Chyba tak musi być. jeżeli wszystkie zaznaczone kwalifikatory się zgadzają
            // to dopiero wtedy możemy powiedzieć, że dom się kwalifikuje czy nie
            if (membership > 0.5) {
                // TODO adjust this if statement properly
                this.qualifiedHouses.add(house);
                this.numberOfQualifiedHouses++;
            }

        }
        // TODO i teraz wygenerować summary w zależności od tych membership co wyszło
        for (Quantifier quantifier : this.quantifiers) {
            Label bestQuantifierLabel = quantifier.getLabels().get(0);
            if (quantifier.isRelevant()) {
                // TODO do this statement
                String summary = "";
                this.summaries.add(summary);
            } else {
                for (Label label : quantifier.getLabels()) {
                    if (label.getMembership(this.numberOfQualifiedHouses) > bestQuantifierLabel.getMembership(this.numberOfQualifiedHouses)) {
                        bestQuantifierLabel = label;
                    }
                }
                StringBuilder summary = new StringBuilder(bestQuantifierLabel.getLabel() + " houses are ");
                for (int i = 0; i < summarizers.size(); i++) {
                    summary.append(summarizers.get(i).getLabel());
                    if (i + 1 < summarizers.size()){
                        summary.append(", ");
                    }
                    else {
                        summary.append(".");
                    }
                }
                this.summaries.add(summary.toString());
            }
        }
    }

    private String getLinguisticVariableName(String name) {
        // TODO ADJUST DUE TO SPRAWOZDANIE XD
        List<String> price = Arrays.asList("Very cheap (under 275000)", "Cheap (around 327000)", "Medium (around 535000)", "Expensive (around 743000)", "Very expensive (above 899000)");
        List<String> landArea = Arrays.asList("Tiny area", "Small area", "Average area", "Large area", "Gigantic area");
        // TODO ADD OTHER LISTS
        if (price.contains(name)) {
            return "PRICE";
        } else if (landArea.contains(name)) {
            return "LAND_AREA";
        } else return "";
    }

    public List<String> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<String> summaries) {
        this.summaries = summaries;
    }

    public void addSummaries(String summary) {
        this.summaries.add(summary);
    }

    public int getNumberOfQualifiedHouses() {
        return numberOfQualifiedHouses;
    }

    public List<House> getQualifiedHouses() {
        return qualifiedHouses;
    }
}
