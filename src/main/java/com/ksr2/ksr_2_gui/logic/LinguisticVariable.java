package ksr2.logic;

import java.util.List;

public class LinguisticVariable {
    private String name;
    private List<Label> labels;

    public LinguisticVariable(String name, List<Label> labels) {
        this.name = name;
        this.labels = labels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
