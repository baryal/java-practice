package com.practice.dateandtime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TestDateAndTime {
  public static void main(String[] args) {
    LocalDate localDate1 = LocalDate.now();
    System.out.println(localDate1);

    Clock clock = Clock.systemDefaultZone();
    LocalDate localDate2 = LocalDate.now(clock);
    System.out.println(localDate2);

    ZoneId zoneId = ZoneId.of("America/Phoenix");
    LocalDate localDate3 = LocalDate.now(zoneId);
    System.out.println(localDate3);

    LocalDate localDate4 = LocalDate.of(2018, 12, 15);
    System.out.println(localDate4);

    LocalDate localDate5 = LocalDate.parse("2018-12-16");
    System.out.println(localDate5);

    LocalDateTime localDateTime = LocalDateTime.of(2018, Month.AUGUST, 20, 6, 30);
    String format = localDateTime.format(DateTimeFormatter.ISO_DATE);
    System.out.println(format);
    String format1 = localDateTime.format(DateTimeFormatter.ofPattern("MM/dd/YYYY"));
    System.out.println(format1);

    Period period = Period.ofDays(5);
    LocalDate localDate6 = localDate5.plusDays(3);
    System.out.println(localDate6);




  }
}
