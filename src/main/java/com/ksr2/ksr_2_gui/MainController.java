package com.ksr2.ksr_2_gui;

import com.ksr2.ksr_2_gui.logic.*;
import com.ksr2.ksr_2_gui.logic.Label;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TextField t1_input;
    @FXML
    private TextField t2_input;
    @FXML
    private TextField t3_input;
    @FXML
    private TextField t4_input;
    @FXML
    private TextField t5_input;
    @FXML
    private TextField t6_input;
    @FXML
    private TextField t7_input;
    @FXML
    private TextField t8_input;
    @FXML
    private TextField t9_input;
    @FXML
    private TextField t10_input;
    @FXML
    private TextField t11_input;

    @FXML
    private TreeView summarizatorsTreeView;

    @FXML
    private Button button_generate;

    // Code
    private Initializer initializer;
    private List<LinguisticVariable> linguisticVariables;
    private List<House> houses;
    private List<Quantifier> quantifiers;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.initializer = new Initializer();
        this.linguisticVariables = initializer.createLinguisticVariable();
        try {
            this.houses = initializer.getAllHouses();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.quantifiers = initializer.createQuantifiers();


        TreeItem<String> rootItem = new TreeItem<>("Sumaryzatory");
        rootItem.setExpanded(true);

        for (LinguisticVariable linguisticVariable : this.linguisticVariables) {
            TreeItem<String> childItem = new TreeItem<>(linguisticVariable.getName());
            for (Label label : linguisticVariable.getLabels()) {
                CheckBoxTreeItem<String> variable = new CheckBoxTreeItem<>(label.getLabel());
                childItem.getChildren().add(variable);
            }
            rootItem.getChildren().add(childItem);
        }
        summarizatorsTreeView.setRoot(rootItem);


    }

    private List<Label> getCheckedSummarizers() {
        List<String> checkedVariables = new ArrayList<>();
        for(Object item: summarizatorsTreeView.getRoot().getChildren()) {

            //TODO
        }
        return new ArrayList<>();
    }

    private List<Double> getMeasuresWeights() {
        List<Double> measuresWeights = new ArrayList<>();
        measuresWeights.add(Double.valueOf(t1_input.getText()));
        measuresWeights.add(Double.valueOf(t2_input.getText()));
        measuresWeights.add(Double.valueOf(t3_input.getText()));
        measuresWeights.add(Double.valueOf(t4_input.getText()));
        measuresWeights.add(Double.valueOf(t5_input.getText()));
        measuresWeights.add(Double.valueOf(t6_input.getText()));
        measuresWeights.add(Double.valueOf(t7_input.getText()));
        measuresWeights.add(Double.valueOf(t8_input.getText()));
        measuresWeights.add(Double.valueOf(t9_input.getText()));
        measuresWeights.add(Double.valueOf(t10_input.getText()));
        measuresWeights.add(Double.valueOf(t11_input.getText()));

        return measuresWeights;
    }

    @FXML
    protected void onGenerateButtonClick() {
        // Getters from GUI
        List<Label> summarizers = this.getCheckedSummarizers();
        List<Double> measuresWeights = this.getMeasuresWeights();

        // prepare summaries
        Summary summary = new Summary(houses, quantifiers);
        summary.createSummaries(summarizers);
        Measures measures = new Measures(measuresWeights);
        measures.calculateMeasures();

        // Show on gui
        List<String> generatedSummaries = summary.getSummaries();
        for (String generatedSummary : generatedSummaries) {
            System.out.println(generatedSummary);
            // TODO show
        }
        // TODO getters for all measures T1-T11
    }
}