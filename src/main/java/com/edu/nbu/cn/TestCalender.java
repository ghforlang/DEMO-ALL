package com.edu.nbu.cn;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TestCalender {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");

    private static final DateTimeFormatter startOfDayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
    private static final DateTimeFormatter endOfDayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 23:59:59");
    private static final String startOfDayFormat = "yyyy-MM-dd 00:00:00";
    private static final String endOfDayFormat = "yyyy-MM-dd 23:59:59";

    public static void main(String[] args) throws ParseException {

//        Calendar c = Calendar.getInstance();
//        System.out.println(c.getTime());
//        c.add(Calendar.SECOND,1);
//        System.out.println(c.getTime());
//
//        LocalDate now = LocalDate.now();
//        System.out.println(now.format(formatter));
//
//        System.out.println(ORDER_LIST_SEARCH_ALL_FIELDS_FL)
    }
}
