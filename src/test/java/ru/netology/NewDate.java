package ru.netology;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewDate {

    public String newDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}