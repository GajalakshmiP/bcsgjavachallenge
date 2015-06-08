package com.local.bcsgjavachallenge;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests CSVReader
 */
public class CSVReaderTest {

    private String csvFile;
    private String csvFileDoesNotExist;

    @Before
    public void setUp() throws URISyntaxException {
        csvFile = getClass().getClassLoader().getResource("bcsg.csv").getPath();
        csvFileDoesNotExist = "bcsgDoesNotExist.csv";
    }

    /**
     * Test of readCSV method, of class CSVReader.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testReadCSV() throws IOException {
        System.out.println("readCSV");
        CSVReader instance = new CSVReader();
        List<Map<String, String>> list = instance.readCSV(csvFile);

        List<Map<String, String>> expected = new ArrayList<>();
        Map dataOne = new HashMap();
        dataOne.put(BcsgTestResources.BANK_HEADER, "HSBC Canada");
        dataOne.put(BcsgTestResources.CARDNUMBER_HEADER, "5601-2345-3446-5678");
        dataOne.put(BcsgTestResources.EXPIRYDATE_HEADER, "Nov-2017");
        expected.add(dataOne);
        Map dataTwo = new HashMap();
        dataTwo.put(BcsgTestResources.BANK_HEADER, "Royal Bank of  Canada");
        dataTwo.put(BcsgTestResources.CARDNUMBER_HEADER, "4519-4532-4524-2456");
        dataTwo.put(BcsgTestResources.EXPIRYDATE_HEADER, "Oct-2017");
        expected.add(dataTwo);
        Map dataThree = new HashMap();
        dataThree.put(BcsgTestResources.BANK_HEADER, "American Express");
        dataThree.put(BcsgTestResources.CARDNUMBER_HEADER, "3786-7334-8965-345");
        dataThree.put(BcsgTestResources.EXPIRYDATE_HEADER, "Dec-2018");
        expected.add(dataThree);

        assertEquals(expected.size(), list.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), list.get(i));
        }
    }

    @Test(expected = IOException.class)
    public void testReadCSVDoesNotExist() throws IOException {
        System.out.println("readCSV does not exist");
        CSVReader instance = new CSVReader();
        instance.readCSV(csvFileDoesNotExist);
    }

}
