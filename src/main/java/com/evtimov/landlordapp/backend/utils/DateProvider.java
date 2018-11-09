package com.evtimov.landlordapp.backend.utils;

import org.joda.time.LocalDateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProvider {

    public Date getDateBeforeThreeMonths(){

        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        LocalDateTime beforeNinetyDays = currentLocalDateTime.minusMonths(3);
        Date date = beforeNinetyDays.toDate();

        return date;
    }

    public String getDateAfterOneMonth(String lastDate) {

        LocalDateTime currentLocalDateTime = LocalDateTime.parse(lastDate);
        LocalDateTime afterOneMonth = currentLocalDateTime.plusMonths(1);
        Date date = afterOneMonth.toDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String paymentDate = format.format(date);

        return paymentDate;
    }
}
