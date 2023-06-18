package com.ksr2.ksr_2_gui;


import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ksr2.ksr_2_gui.database.Database;
import com.ksr2.ksr_2_gui.logic.*;
import com.ksr2.ksr_2_gui.logic.membershipFunction.MembershipFunction;
import com.ksr2.ksr_2_gui.logic.membershipFunction.MembershipFunctionFactory;
import com.ksr2.ksr_2_gui.logic.membershipFunction.Trapezoidal;
import com.ksr2.ksr_2_gui.logic.membershipFunction.Triangular;
import javafx.scene.chart.PieChart;
import org.json.JSONArray;
import org.json.JSONObject;


public class Initializer {
    public List<LinguisticVariable> createLinguisticVariable() {
        List<LinguisticVariable> linguisticVariables = new ArrayList<>();

        try {
            URL filePath = Initializer.class.getResource("linguisticsVariables.json");
            assert filePath != null;
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath.toURI())));
            JSONObject data = new JSONObject(jsonContent);

            for (String key : data.keySet()) {
                JSONObject value = data.getJSONObject(key);
                String function = value.getString("function");

                JSONObject variables = value.getJSONObject("variables");

                List<Label> labelList = new ArrayList<>();
                for (Map.Entry<String, Object> entry : variables.toMap().entrySet()) {
                    String variableName = entry.getKey();
                    Object variableDict = entry.getValue();

                    List<Double> variableValues = new ArrayList<>();
                    if (variableDict instanceof HashMap<?, ?> hashMap) {
                        for (Object corner : hashMap.values()) {
                            variableValues.add(((Number) corner).doubleValue());
                        }
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

    public List<Quantifier> createQuantifiers() {
        List<Quantifier> quantifiers = new ArrayList<>();
        boolean isRelevant;

        for (int i = 0; i <= 1; i++) {
            List<Label> labels = new ArrayList<>();
            if (i == 0) {
                isRelevant = false;
                labels.add(new Label("Less than 3000", new FuzzySet(new Triangular(0, 3600, 6200))));
                labels.add(new Label("Around 7500", new FuzzySet(new Triangular(4900, 7500, 10100))));
                labels.add(new Label("Close to 11000", new FuzzySet(new Triangular(8800, 11400, 14000))));
                labels.add(new Label("Over 13000", new FuzzySet(new Triangular(12700, 15300, 33656))));
            } else {
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

    public List<House> getAllHouses() throws SQLException {
        List<House> houses = new ArrayList<>();
        Database db = new Database();
        ResultSet results = db.getFromQuery("SELECT * FROM house");
        while (results.next()) {
            String address = results.getString("ADDRESS");
            String suburb = results.getString("SUBURB");
            // Values
            double price = results.getDouble("PRICE");
            double landArea = results.getDouble("LAND_AREA");
            double floorArea = results.getDouble("FLOOR_AREA");
            double buildYear = results.getDouble("BUILD_YEAR");
            double cbdDistance = results.getDouble("CBD_DIST");
            double nearestStdDistance = results.getDouble("NEAREST_STN_DIST");
            double lastSoldTime = results.getDouble("DATE_SOLD");
            double latitude = results.getDouble("LATITUDE");
            double longitude = results.getDouble("LONGITUDE");
            double neatestSchoolDistance = results.getDouble("NEAREST_SCH_DIST");

            houses.add(new House(address, suburb, price, landArea, floorArea, buildYear, cbdDistance, nearestStdDistance,
                    lastSoldTime, latitude, longitude, neatestSchoolDistance));
        }
        return houses;
    }
}
