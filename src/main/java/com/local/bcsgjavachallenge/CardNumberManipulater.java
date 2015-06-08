package com.local.bcsgjavachallenge;

import java.util.Map;

/**
 * Mask card number based on the bank name.
 */
public class CardNumberManipulater {

    /**
     * Mask card number using the defined mask format for different banks
     *
     * @param account
     * @return
     */
    public static Map<String, String> maskCardNumber(Map<String, String> account) {
        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        String maskFormat = getMaskFormat(account.get(BcsgResources.BANK_HEADER));
        for (int i = 0; i < maskFormat.length(); i++) {
            char c = maskFormat.charAt(i);
            if (c == '#') {
                maskedNumber.append(account.get(BcsgResources.CARDNUMBER_HEADER).charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
                index++;
            }
        }

        account.put(BcsgResources.CARDNUMBER_HEADER, maskedNumber.toString());
        return account;
    }

    /**
     * Define mask format for the card number for different banks
     *
     * @param bank
     * @return
     */
    private static String getMaskFormat(String bank) {
        String format = null;
        switch (bank) {
            case BcsgResources.HSBC_CANADA:
                format = "##xx-xxxx-xxxx-xxxx";
                break;
            case BcsgResources.ROYAL_BANK_OF_CANADA:
                format = "####-xxxx-xxxx-xxxx";
                break;
            case BcsgResources.AMERICAN_EXPRESS:
                format = "xxxx-xxxx-xxxx-###";
                break;
        }
        return format;
    }
}
