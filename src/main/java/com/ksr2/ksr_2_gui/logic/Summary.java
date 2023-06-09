package com.ksr2.ksr_2_gui.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Summary {
    // List of houses
    List<House> houses = new ArrayList<>();
    // generated summaries
    private  List<String> summaries = new ArrayList<>();
    // TODO zmienne które się łapią
    private List<House> qualifiedHouses = new ArrayList<>();


    public Summary(List<House> houses) { // From database
        this.houses = houses;
    }

    public List<String> createSummaries(List<Label> qualifiers){  // TODO mayve this should be named summarizers
//        private lista domów, potem przeiterować wszystkie i zliczać te które załapują się w kwantyfikator a następnie możemy dodać
//        te zmienne które wynikają z tych liczb
        for (Label qualifier : qualifiers) {
            for (House house: this.houses){
                double membership = qualifier.getValue().getMembershipFunction().getMembership(house.getByName(this.getLinguisticVariableName(qualifier.getLabel())));
            // TODO zrobić coś w stylu if membership > 0.5 then house qualified.
            }
        }
        // TODO i teraz wygenerować summary w zależności od tych membership co wyszło
        return this.summaries;
    }
    private String getLinguisticVariableName(String name){
        // TODO ADJUST DUE TO SPRAWOZDANIE XD
        List<String> price = Arrays.asList("Very cheap (under 275000)", "Cheap (around 327000)", "Medium (around 535000)", "Expensive (around 743000)", "Very expensive (above 899000)");
        List<String> landArea = Arrays.asList("Tiny area", "Small area", "Average area", "Large area", "Gigantic area");
        // TODO ADD OTHER LISTS
        if (price.contains(name)){return "PRICE";}
        else if (landArea.contains(name)){return "LAND_AREA";}
        else return "";
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
}
