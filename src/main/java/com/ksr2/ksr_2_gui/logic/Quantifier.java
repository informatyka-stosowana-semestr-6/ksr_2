package com.ksr2.ksr_2_gui.logic;

import java.util.List;

public class Quantifier {
    private boolean isRelevant;
    private List<Label> labels;

    public Quantifier(boolean isRelevant, List<Label> labels) {
        this.isRelevant = isRelevant;
        this.labels = labels;
    }

    public boolean isRelevant() {
        return isRelevant;
    }

    public void setRelevant(boolean relevant) {
        isRelevant = relevant;
    }

    public List<Label> getLabels() {
        return labels;
    }
    // TODO consider adding getLabel(int index)

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
