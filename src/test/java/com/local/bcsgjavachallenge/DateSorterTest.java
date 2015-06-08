package com.local.bcsgjavachallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests DateSorter class
 */
public class DateSorterTest {

    Map<String, String> hsbc;
    Map<String, String> royalBankOfCanada;
    Map<String, String> americanExpress;
    Map<String, String> americanExpressParseError;
    List<Map<String, String>> expected;

    @Before
    public void setUp() {
        expected = new ArrayList<>();
        hsbc = new HashMap();
        hsbc.put(BcsgTestResources.BANK_HEADER, "HSBC Canada");
        hsbc.put(BcsgTestResources.CARDNUMBER_HEADER, "5601-2345-3446-5678");
        hsbc.put(BcsgTestResources.EXPIRYDATE_HEADER, "Nov-2017");
        expected.add(hsbc);
        royalBankOfCanada = new HashMap();
        royalBankOfCanada.put(BcsgTestResources.BANK_HEADER, "Royal Bank of  Canada");
        royalBankOfCanada.put(BcsgTestResources.CARDNUMBER_HEADER, "4519-4532-4524-2456");
        royalBankOfCanada.put(BcsgTestResources.EXPIRYDATE_HEADER, "Oct-2017");
        expected.add(royalBankOfCanada);
        americanExpress = new HashMap();
        americanExpress.put(BcsgTestResources.BANK_HEADER, "American Express");
        americanExpress.put(BcsgTestResources.CARDNUMBER_HEADER, "3786-7334-8965-345");
        americanExpress.put(BcsgTestResources.EXPIRYDATE_HEADER, "Dec-2018");
        expected.add(americanExpress);
        americanExpressParseError = new HashMap();
        americanExpressParseError.put(BcsgTestResources.BANK_HEADER, "American Express");
        americanExpressParseError.put(BcsgTestResources.CARDNUMBER_HEADER, "3786-7334-8965-345");
        americanExpressParseError.put(BcsgTestResources.EXPIRYDATE_HEADER, "Dec 2018");
        expected.add(americanExpressParseError);
    }

    /**
     * Test of compare method, of class DateSorter.
     *
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        DateSorter instance = new DateSorter();
        int result = instance.compare(royalBankOfCanada, hsbc);
        int result1 = instance.compare(americanExpress, royalBankOfCanada);
        assertEquals(-1, result1);
        assertEquals(1, result);
    }

    @Test
    public void testCompareForException() {
        System.out.println("compare for exception");
        DateSorter instance = new DateSorter();
        instance.compare(royalBankOfCanada, americanExpressParseError);

    }
}
