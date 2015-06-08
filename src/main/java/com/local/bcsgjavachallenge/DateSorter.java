package com.local.bcsgjavachallenge;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Compares dates date1 and date2. Return 1 if date2 is greater than date1.
 * Return -1 if date2 is less than date1 i.e., Sort by descending order
 */
public class DateSorter implements Comparator<Map<String, String>> {

    @Override
    public int compare(Map<String, String> o1, Map<String, String> o2) {
        DateFormat format = new SimpleDateFormat(BcsgResources.DATE_FORMAT);
        Date dateOne = null;
        Date dateTwo = null;
        try {
            dateOne = format.parse(o2.get(BcsgResources.EXPIRYDATE_HEADER));
            dateTwo = format.parse(o1.get(BcsgResources.EXPIRYDATE_HEADER));
        } catch (ParseException ex) {
            Logger.getLogger(DateSorter.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dateOne == null || dateTwo == null) {
            return 0;
        }
        return dateOne.compareTo(dateTwo);

    }

}
