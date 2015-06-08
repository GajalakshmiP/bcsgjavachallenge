package com.local.bcsgjavachallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

/**
 * Read CSV data and add each row of the file to a map - the keys are the
 * headers of the CSV file. Each row is added to a list and the list of rows is
 * returned
 */
public class CSVReader {

    public List<Map<String, String>> readCSV(String csvFile) throws IOException {

        try {

            CsvListReader csvReader = new CsvListReader(new BufferedReader(new FileReader(csvFile)), CsvPreference.STANDARD_PREFERENCE);

            //Read CSV Header
            List<String> header = new ArrayList<>(csvReader.read());
            List<String> rowAsTokens;

            //Read the CSV as List of Maps where each Map represents row data
            List<Map<String, String>> rows = new ArrayList<>();
            Map<String, String> row;

            while ((rowAsTokens = csvReader.read()) != null) {

                //Create Map for each row in CSV
                row = new HashMap<>();

                for (int i = 0; i < header.size(); i++) {
                    row.put(header.get(i), rowAsTokens.get(i));
                }

                //add Row map to list of rows
                rows.add(row);
            }
            return rows;
        } catch (Exception IOException) {
            throw new IOException("Error reading csv file. Please check the file supplied");
        }

    }
}
