package com.local.bcsgjavachallenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JavaChallenge {

    public static void main(String[] args) throws IOException {

        //Read data from the supplied CSV file
        List<Map<String, String>> csvData = readCsv(args[0]);
        List<Map<String, String>> maskedList = new ArrayList<>();

        //Mask card number
        maskCardNumber(csvData, maskedList);

        //Sort the list of maps in descending order
        Collections.sort(maskedList, new DateSorter());

        //Print the result
        printOutput(maskedList);
    }

    private static List<Map<String, String>> readCsv(String csvFile) throws IOException {
        CSVReader reader = new CSVReader();
        List<Map<String, String>> list = reader.readCSV(csvFile);
        return list;
    }

    private static void maskCardNumber(List<Map<String, String>> list, List<Map<String, String>> maskedList) {
        for (Map<String, String> key : list) {
            CardNumberManipulater.maskCardNumber(key);
            maskedList.add(key);
        }
    }

    private static void printOutput(List<Map<String, String>> maskedList) {
        for (Map<String, String> processedMap : maskedList) {
            System.out.println(processedMap);
        }
    }

}
