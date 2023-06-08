package com.ksr2.ksr_2_gui;



import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.ksr2.ksr_2_gui.logic.FuzzySet;
import com.ksr2.ksr_2_gui.logic.Label;
import com.ksr2.ksr_2_gui.logic.LinguisticVariable;
import com.ksr2.ksr_2_gui.logic.membershipFunction.MembershipFunction;
import com.ksr2.ksr_2_gui.logic.membershipFunction.MembershipFunctionFactory;
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
}
