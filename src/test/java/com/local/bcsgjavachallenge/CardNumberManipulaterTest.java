package com.local.bcsgjavachallenge;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests CardManipulator class
 */
public class CardNumberManipulaterTest {

    @Test
    public void testMaskCardNumberHSBCCanada() {
        System.out.println("maskCardNumberHSBCCanada");

        Map hsbc = new HashMap();
        hsbc.put(BcsgTestResources.BANK_HEADER, "HSBC Canada");
        hsbc.put(BcsgTestResources.CARDNUMBER_HEADER, "5601-2345-3446-5678");
        hsbc.put(BcsgTestResources.EXPIRYDATE_HEADER, "Nov-2017");
        Map expected = new HashMap();
        expected.put(BcsgTestResources.BANK_HEADER, "HSBC Canada");
        expected.put(BcsgTestResources.CARDNUMBER_HEADER, "56xx-xxxx-xxxx-xxxx");
        expected.put(BcsgTestResources.EXPIRYDATE_HEADER, "Nov-2017");

        Map<String, String> result = CardNumberManipulater.maskCardNumber(hsbc);
        assertEquals(expected.get(BcsgTestResources.CARDNUMBER_HEADER), result.get(BcsgTestResources.CARDNUMBER_HEADER));

    }

    @Test
    public void testMaskCardNumberRoyalBankOfCanada() {
        System.out.println("maskCardNumberRoyalBankOfCanada");

        Map hsbc = new HashMap();
        hsbc.put(BcsgTestResources.BANK_HEADER, "Royal Bank of  Canada");
        hsbc.put(BcsgTestResources.CARDNUMBER_HEADER, "4519-4532-4524-2456");
        hsbc.put(BcsgTestResources.EXPIRYDATE_HEADER, "Oct-2017");
        Map expected = new HashMap();
        expected.put(BcsgTestResources.BANK_HEADER, "Royal Bank of  Canada");
        expected.put(BcsgTestResources.CARDNUMBER_HEADER, "4519-xxxx-xxxx-xxxx");
        expected.put(BcsgTestResources.EXPIRYDATE_HEADER, "Oct-2017");

        Map<String, String> result = CardNumberManipulater.maskCardNumber(hsbc);
        assertEquals(expected.get(BcsgTestResources.CARDNUMBER_HEADER), result.get(BcsgTestResources.CARDNUMBER_HEADER));

    }

    @Test
    public void testMaskCardNumberAmericanExpress() {
        System.out.println("maskCardNumberAmericanExpress");

        Map hsbc = new HashMap();
        hsbc.put(BcsgTestResources.BANK_HEADER, "American Express");
        hsbc.put(BcsgTestResources.CARDNUMBER_HEADER, "3786-7334-8965-345");
        hsbc.put(BcsgTestResources.EXPIRYDATE_HEADER, "Dec-2018");
        Map expected = new HashMap();
        expected.put(BcsgTestResources.BANK_HEADER, "American Express");
        expected.put(BcsgTestResources.CARDNUMBER_HEADER, "xxxx-xxxx-xxxx-345");
        expected.put(BcsgTestResources.EXPIRYDATE_HEADER, "Dec-2018");

        Map<String, String> result = CardNumberManipulater.maskCardNumber(hsbc);
        assertEquals(expected.get(BcsgTestResources.CARDNUMBER_HEADER), result.get(BcsgTestResources.CARDNUMBER_HEADER));

    }

}
