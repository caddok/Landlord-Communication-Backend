package com.evtimov.landlordapp.backend.utils;

import org.joda.time.LocalDateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProvider {

    public String getDateBeforeThreeMonths(){

        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        LocalDateTime beforeNinetyDays = currentLocalDateTime.minusMonths(Constants.DELETE_MESSAGES_MONTHS_PERIOD);
        Date date = beforeNinetyDays.toDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(date);

        return strDate;
    }

    public String getDateAfterOneMonth(String lastDate) {

        LocalDateTime currentLocalDateTime = LocalDateTime.parse(lastDate);
        LocalDateTime afterOneMonth = currentLocalDateTime.plusMonths(1);
        Date date = afterOneMonth.toDate();
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_PATTERN);
        String paymentDate = format.format(date);

        return paymentDate;
    }
}
