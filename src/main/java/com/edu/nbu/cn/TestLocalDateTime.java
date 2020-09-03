package com.edu.nbu.cn;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestLocalDateTime {

    private static final ZoneId localZoneId = ZoneId.systemDefault();

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().minusMonths(3);
        Date date = Date.from(now.atZone(localZoneId).toInstant());
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        List<Date> nowHours = new ArrayList<>();

        LocalDateTime ldtYestoday = now.minusHours(24);
        nowHours.add(Date.from(ldtYestoday.atZone(localZoneId).toInstant()));
        for(int i=0; i<24 ;i++){
            ldtYestoday = ldtYestoday.plusHours(1L);
            nowHours.add(Date.from(ldtYestoday.atZone(localZoneId).toInstant()));
            System.out.println(ldtYestoday.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
//        nowHours.forEach(nowHour -> System.out.println(nowHour));
    }
}
