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
    private final List<House> qualifiedHouses = new ArrayList<>();
    private int numberOfQualifiedHouses = 0;


    public Summary(List<House> houses, List<Quantifier> quantifiers) { // From database
        this.houses = houses;
        this.quantifiers = quantifiers;
    }

    public void createSummaries(List<Label> summarizers) {
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
        for (Quantifier quantifier : this.quantifiers) {
            double valueToGetMembership;
            if (quantifier.isRelevant()) {
                valueToGetMembership = (double) this.numberOfQualifiedHouses / this.houses.size(); // Relevant value
            } else {
                valueToGetMembership = this.numberOfQualifiedHouses;
            }

            Label bestQuantifierLabel = quantifier.getLabels().get(0);
            for (Label label : quantifier.getLabels()) {
                if (label.getMembership(valueToGetMembership) > bestQuantifierLabel.getMembership(valueToGetMembership)) {
                    bestQuantifierLabel = label;
                }
            }
            StringBuilder summary = new StringBuilder(bestQuantifierLabel.getLabel() + " houses are ");
            for (int i = 0; i < summarizers.size(); i++) {
                summary.append(summarizers.get(i).getLabel());
                if (i + 1 < summarizers.size()) {
                    summary.append(", ");
                } else {
                    summary.append(".");
                }
            }
            this.summaries.add(summary.toString());
        }
    }

    private String getLinguisticVariableName(String name) {
        List<String> price = Arrays.asList("Very cheap (under 275000)", "Cheap (around 327000)", "Medium (around 535000)", "Expensive (around 743000)", "Very expensive (above 899000)");
        List<String> landArea = Arrays.asList("Tiny area (under 250 m2)", "Small area (around 550 m2)", "Average area (around 1500 m2)", "Large area (around 2500 m2)", "Gigantic area (above 3000 m2)");
        List<String> floorArea = Arrays.asList("Claustrophobic (under 50 m2)", "Average (around 200 m2)", "Moderate (around 400 m2)", "Spatial (around 600 m2)", "Enormous (above 700 m2)");
        List<String> buildYear = Arrays.asList("Aged (before 1890)", "Old (before 1920)", "Medium age (around 1940)", "New (later than 1980)", "Recently built (later than 2010)");
        List<String> cbdDistance = Arrays.asList("Nearby (under 5 minutes)", "Close (around 25 minutes)", "Moderate (around 45 minutes)", "Far (nearly 2 hours)", "Very far (above 2.5 hours)");
        List<String> nearestStdDist = Arrays.asList("Nearby (around 4 minutes)", "Close (around 15 minutes)", "Moderate (under 1 hour)", "Far (above 1.5 hour)", "Very far (more than 2 hour)");
        List<String> lastSoldTime = Arrays.asList("Recently (less than 1500 days ago)", "Lately (less than 5000 days ago)", "Long time ago (more than 8000 days ago)", "Very long time ago (more than 10000 days ago)");
        List<String> latitude = Arrays.asList("Southern latitude", "Central latitude", "Northern latitude");
        List<String> longitude = Arrays.asList("Western longitude", "Central longitude", "Eastern longitude");
        List<String> nearestSchDistance = Arrays.asList("Nearby (less than 5 minutes)", "Close (less than 12 minutes)", "Moderate (around 24 minutes)", "Far (above 35 minutes)", "Very far (above 1.5 hour)");
        if (price.contains(name)) {
            return "PRICE";
        } else if (landArea.contains(name)) {
            return "LAND_AREA";
        } else if (floorArea.contains(name)) {
            return "FLOOR_AREA";
        } else if (buildYear.contains(name)) {
            return "BUILD_YEAR";
        } else if (cbdDistance.contains(name)) {
            return "CBD_DIST";
        } else if (nearestStdDist.contains(name)) {
            return "NEAREST_STN_DIST";
        } else if (lastSoldTime.contains(name)) {
            return "DATE_SOLD";
        } else if (latitude.contains(name)) {
            return "LATITUDE";
        } else if (longitude.contains(name)) {
            return "LONGITUDE";
        } else if (nearestSchDistance.contains(name)) {
            return "NEAREST_SCH_DIST";
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
