package com.ksr2.ksr_2_gui.logic;

public class Label {
    private String label;
    private FuzzySet value;

    public Label(String label, FuzzySet value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public FuzzySet getValue() {
        return value;
    }

    public void setValue(FuzzySet value) {
        this.value = value;
    }

    public double getMembership(double x){
        return this.value.getMembership(x);
    }
}
