//package com.ksr2.ksr_2_gui;
//
//import ksr2.logic.LinguisticVariable;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Iterator;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//public class Initializer {
//    public List<LinguisticVariable> createLinguisticVariable() throws IOException, ParseException {
//        List<LinguisticVariable> linguisticVariables = new ArrayList<>();
//        JSONParser parser = new JSONParser();
//        Object obj = parser.parse(new FileReader("D:\\studia\\semestr_8\\KSR\\ksr_2\\src\\main\\resources\\linguisticsVariables.json"));
//        JSONObject jsonObject =  (JSONObject) obj;
////        TODO
//        return linguisticVariables;
//    }
//}
