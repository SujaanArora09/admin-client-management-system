package com.fitness.tracker.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
