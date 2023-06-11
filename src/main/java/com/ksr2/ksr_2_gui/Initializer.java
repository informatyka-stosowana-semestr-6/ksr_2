package com.ksr2.ksr_2_gui;



import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.ksr2.ksr_2_gui.logic.*;
import com.ksr2.ksr_2_gui.logic.membershipFunction.MembershipFunction;
import com.ksr2.ksr_2_gui.logic.membershipFunction.MembershipFunctionFactory;
import com.ksr2.ksr_2_gui.logic.membershipFunction.Trapezoidal;
import com.ksr2.ksr_2_gui.logic.membershipFunction.Triangular;
import org.json.JSONArray;
import org.json.JSONObject;


public class Initializer {
    public List<LinguisticVariable> createLinguisticVariable() {
        List<LinguisticVariable> linguisticVariables = new ArrayList<>();

        try {
//            TODO
//            String filePath = Paths.get(System.getProperty("user.dir"), "resources/linguisticsVariables.json").toString();
            String filePath = "D:\\studia\\semestr_8\\KSR\\ksr_2\\src\\main\\resources\\linguisticsVariables.json";
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject data = new JSONObject(jsonContent);

            for (String key : data.keySet()) {
                JSONObject value = data.getJSONObject(key);
                String function = value.getString("function");

                JSONArray variables = value.getJSONArray("variables");
                List<Label> labelList = new ArrayList<>();

                for (int i = 0; i < variables.length(); i++) {
                    JSONObject variableValue = variables.getJSONObject(i);
                    String variableName = variableValue.keys().next();
                    JSONArray variableArray = variableValue.getJSONArray(variableName);

                    List<Double> variableValues = new ArrayList<>();
                    for (int j = 0; j < variableArray.length(); j++) {
                        variableValues.add(variableArray.getDouble(j));
                    }

                    MembershipFunction membershipFunction = MembershipFunctionFactory.createObject(function, variableValues);
                    FuzzySet fuzzySet = new FuzzySet(membershipFunction);
                    Label label = new Label(variableName, fuzzySet);
                    labelList.add(label);
                }

                LinguisticVariable linguisticVariable = new LinguisticVariable(key, labelList);
                linguisticVariables.add(linguisticVariable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return linguisticVariables;
    }
    public List<Quantifier> createQuantifiers(){
        List<Quantifier> quantifiers = new ArrayList<>();
        boolean isRelevant;

        for(int i = 0; i<=1; i++){
            List<Label> labels = new ArrayList<>();
            if (i == 0){
                isRelevant = false;
                labels.add(new Label("Less than 3000", new FuzzySet(new Triangular(0, 3600, 6200))));
                labels.add(new Label("Around 7500", new FuzzySet(new Triangular(4900, 7500, 10100))));
                labels.add(new Label("Close to 11000", new FuzzySet(new Triangular(8800, 11400, 14000))));
                labels.add(new Label("Over 13000", new FuzzySet(new Triangular(12700, 15300, 33656))));
            }
            else {
                isRelevant = true;
                labels.add(new Label("Almost none", new FuzzySet(new Trapezoidal(0, 0.05, 0.05, 0.23))));
                labels.add(new Label("A bit", new FuzzySet(new Trapezoidal(0.12, 0.2, 0.33, 0.47))));
                labels.add(new Label("About half", new FuzzySet(new Trapezoidal(0.33, 0.42, 0.6, 0.7))));
                labels.add(new Label("A lot", new FuzzySet(new Trapezoidal(0.6, 0.7, 0.82, 0.87))));
                labels.add(new Label("Almost all", new FuzzySet(new Trapezoidal(0.82, 0.9, 1, 1))));
            }
            quantifiers.add(new Quantifier(isRelevant, labels));
        }
        return quantifiers;
    }
    public List<House> getAllHouses(){
        List<House> houses = new ArrayList<>();
        // TODO read all houses from database
        return houses;
    }
}
