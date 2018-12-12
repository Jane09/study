package com.study.date;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * jdk 1.8+
 * @author tb
 * @date 2018/12/12 9:44
 */
public class DateDemo {

    public static void main(String[] args) {
        localDate();
        localTime();
        localDateTime();
        instant();
        dateTimeFormatter();
    }


    /**
     * 不可变类
     */
    private static void localDate() {
        LocalDate now = LocalDate.now();
        pf("Now = "+now);
        //指定年月日
        LocalDate first = LocalDate.of(2018, Month.JANUARY,1);
        pf("Special = "+first);
        //指定时区
        LocalDate zone = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        pf("IST = "+zone);
        //1970-1-1往前推
        LocalDate from = LocalDate.ofEpochDay(365);
        pf("365 = "+from);
        //前推天数
        LocalDate year = LocalDate.ofYearDay(2018,100);
        pf("Year = "+year);
    }

    private static void localTime() {
        LocalTime now = LocalTime.now();
        pf("Now = "+now);
        LocalTime first = LocalTime.of(12,12,12,40);
        pf("Special = "+first);
        LocalTime zone = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        pf("Zone = "+zone);
        LocalTime second = LocalTime.ofSecondOfDay(10000);
        pf("Second = "+second);


    }

    private static void localDateTime() {
        LocalDateTime now = LocalDateTime.now();
        pf("Now = "+now);
        LocalDateTime special = LocalDateTime.of(2018,Month.JANUARY,1,12,24,59,300);
        pf("Special = "+special);
        LocalDateTime current = LocalDateTime.of(LocalDate.now(),LocalTime.now());
        pf("Current = "+current);
        LocalDateTime offset = LocalDateTime.ofEpochSecond(10000,0,ZoneOffset.UTC);
        pf("Offset = "+offset);

    }

    /**
     * 用在机器可读的时间格式上的，它以Unix时间戳的形式存储日期时间
     */
    private static void instant(){
        Instant timestamp = Instant.now();
        pf("Timestamp = "+timestamp);
        Instant special = Instant.ofEpochMilli(timestamp.toEpochMilli());
        pf("Special = "+special);
        Duration duration = Duration.ofDays(30);
        pf("Duration = " +duration);
    }


    private static void dateTimeFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        pf("Now = "+LocalDateTime.now().format(formatter));
    }

    private static void pf(String message) {
        System.out.println(message);
    }
}
