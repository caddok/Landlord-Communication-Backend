package com.evtimov.landlordapp.backend.utils;

import org.joda.time.LocalDateTime;
import java.util.Date;

public class DateProvider {

    public Date getDateBeforeThreeMonths(){

        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        LocalDateTime beforeNinetyDays = currentLocalDateTime.minusDays(90);
        Date date = beforeNinetyDays.toDate();

        return date;
    }
}
